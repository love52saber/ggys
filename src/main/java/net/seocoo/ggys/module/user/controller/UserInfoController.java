package net.seocoo.ggys.module.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.constants.UserRoleEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.core.util.MD5Util;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.SendShortMessageUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.core.wechat.Oauth2Util;
import net.seocoo.ggys.core.wechat.SNSUserInfo;
import net.seocoo.ggys.core.wechat.WeixinOauth2Token;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.dto.MerchantUserDTO;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.entity.ValidateCodeDO;
import net.seocoo.ggys.module.user.query.UserInfoQuery;
import net.seocoo.ggys.module.user.service.UserInfoService;
import net.seocoo.ggys.module.user.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangpan
 * @date 2018/5/31 17:26
 */
//@CrossOrigin
@RestController
@RequestMapping(value = "/user")
@Api( value = "用户信息接口", description="用户信息接口")
public class UserInfoController extends BaseController {

  @Autowired
  private UserInfoService userInfoService;
  @Autowired
  private RedisUtil redisUtil;
  @Autowired
  private ValidateCodeService validateCodeService;

  @Autowired
  private MerchantService merchantService;

  @Value("${systemConfig.appId}")
  private String appId;

  @Value("${systemConfig.appSecret}")
  private String appSecret;

  @Value("${wechat.url}")
  private String rurl;

  @Value("${web.index.url}")
  private String webIndexUrl;


  @PostMapping(value = "/save")
  @ApiOperation(value = "保存用户信息")
  public ApiResult saveUserInfo(@RequestBody UserInfoDO userInfoDO) {
    userInfoService.saveUserInfo(userInfoDO);
    return success("保存成功");
  }

  /**
   * 根据id获取用户对象
   * @param id
   * @return
   */
  @GetMapping(value = "/user/{id}")
  @ApiOperation(value = "根据id获取用户信息")
  public ApiResult getUserInfo(@RequestHeader String token, @ApiParam(value = "用户的id") @PathVariable(value = "id") Integer id) {
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null){
      userInfo = userInfoService.getUserInfoById(id);
      redisUtil.set(token,userInfo);
    }
    return success(userInfo);
  }

  /**
   * 获取当前用户对象
   * @param token
   * @return
   */
  @GetMapping(value = "/currentUser")
  @ApiOperation(value = "获取当前用户信息")
  public ApiResult getCurrentUserInfo(@RequestHeader String token) {
    UserInfoDO userInfo = getUserInfoFromToken(token);
    return success(userInfo);
  }

  @GetMapping(value = "/currentMerchantUserInfo")
  public ApiResult getCurrentMerchantUsrInfo(){
    UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());
    if(userInfo == null){
      throw new AppException("用户未登陆或用户信息不存在",RequestCode.Operate_Tip);
    }
    MerchantDO merchantDO = merchantService.getMerchantByMerchantUserId(userInfo.getId());
    if(merchantDO == null) {
      throw  new AppException("登陆用户不是商家",RequestCode.Operate_Tip);
    }

    MerchantUserDTO dto = new MerchantUserDTO();
    dto.setMerchant(merchantDO);
    dto.setUserInfo(userInfo);
    return success(dto);
  }

  /**
   * 更新对象
   * @param userInfoDO
   * @return
   */
  @PostMapping(value = "/update")
  @ApiOperation(value = "更新用户信息")
  public ApiResult updateUserInfo(@RequestHeader String token, @RequestBody UserInfoDO userInfoDO) {
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfoDO.getPassword()!=null && !"".equals(userInfoDO.getPassword())){
      userInfoDO.setPassword(MD5Util.MD5Encode(userInfoDO.getPassword(),"utf-8"));
    }
    userInfoService.updateUserInfo(userInfoDO);
    redisUtil.remove(CacheKeyPrefix.USER_INFO_ID + userInfoDO.getId());
    userInfoDO = userInfoService.getUserInfoById(userInfoDO.getId());
    redisUtil.set(token,userInfoDO,6L,TimeUnit.HOURS);
    return success("更新成功");
  }

  /**
   * 查询list
   * @param userInfoDO
   * @return
   */
  @GetMapping(value = "/list")
  @ApiOperation(value = "获取用户列表")
  public ApiResult queryUserInfoList(UserInfoDO userInfoDO) {
    return success(userInfoService.queryUserInfoList(userInfoDO));
  }

  /**
   * 查询list
   * @return
   */
  @GetMapping(value = "/list/chief")
  @ApiOperation(value = "获取社长列表")
  public ApiResult queryUserMList() {
    UserInfoDO userInfoDO = new UserInfoDO();
    userInfoDO.setCanDeleted(YesNoEnum.N);
    userInfoDO.setUserRole(UserRoleEnum.CHIEF);
    return success(userInfoService.queryUserInfoList(userInfoDO));
  }

  /**
   * 分页查询
   *
   * @param query
   * @return
   */
  @GetMapping(value = "/listByPage")
  @ApiOperation(value = "分页查询用户")
  public ApiResult listByPageQuery(UserInfoQuery query) {
    PageBean<UserInfoDO> userInfoDOList = userInfoService.listByPageQuery(query);
    return success(userInfoDOList);
  }

  /**
   * 删除 假删除
   * @param id
   * @return
   */
  @PostMapping(value = "/delete")
  @ApiOperation(value = "删除用户")
  public ApiResult deleteUserInfo(int id) {
    userInfoService.deleteById(id);
    return success("删除成功");
  }

  @RequestMapping(value = "/getWechatUserInfo")
  @ApiOperation(value = "获取微信用户信息")
  public void getWechatUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
    logger.info("getWechatUserInfo start");
    String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    url = url.replace("APPID", appId);
//    String rurl = "http://yunshe.wangpubang.net/manage/user/getWechatInfo.do";
    logger.info("========rurl============"+rurl);
    String rurl2 = java.net.URLEncoder.encode(rurl,"utf-8");
    url = url.replace("REDIRECT_URI", rurl2);
    //snsapi_userinfo 会征求用户同意，授权后，可以获取用户基本信息
    url = url.replace("SCOPE", "snsapi_userinfo");
//    url = url.replace("SCOPE", "snsapi_base");
    url = url.replace("STATE", "123");
    response.sendRedirect(url);
  }

  /**
   * 获取微信用户的openId等信息
   *
   * @param request
   * @param response
   */
  @RequestMapping(value = "/getWechatInfo")
  @ApiOperation(value = "获取微信用户的openId等信息")
  public void getWechatInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
    logger.info("weixin   ++++++++++++++++  appId----appId==" + appId + "----------appSecret===" + appSecret);
    String code = request.getParameter("code");
    String openId0 = request.getParameter("openId");
    logger.info("code====="+code+";openId0==="+openId0);
    String openid = "";
    UserInfoDO userInfoDO = null;
    if (!"authdeny".equals(code) && code != null) {
      WeixinOauth2Token wot = null;
      wot = Oauth2Util.getOauth2AccessToken(appId, appSecret, code);
      if (wot != null) {
        //获取session中的openId
        String openId = (String) request.getSession().getAttribute("SESSION_USER_OPENID");
        logger.info("=======================weixin openId  0=================：" + openId);
        if (openId == null || "".equals(openId)) {
          openid = wot.getOpenId();
          request.getSession().setAttribute("SESSION_USER_OPENID", openid);
          logger.info("=======================weixin openid  1=======================：" + openid);
          //获取微信的用户信息
          SNSUserInfo snsUserInfo = Oauth2Util.getSNSUserInfo(wot.getAccessToken(), openid);
          request.getSession().setAttribute("SESSION_USER",snsUserInfo);
          userInfoDO = new UserInfoDO();
          userInfoDO.setOpenId(openid);
          List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
          //判断是否已存在数据库中
          if(userInfoDOList.size()<1){
            userInfoDO = new UserInfoDO();
            userInfoDO.setNickname(snsUserInfo.getNickname());
            userInfoDO.setOpenId(snsUserInfo.getOpenId());
            userInfoDO.setHeadImageUrl(snsUserInfo.getHeadImgUrl());
            userInfoService.saveUserInfo(userInfoDO);
            logger.info("=====saveUserInfo===save==success=====id="+userInfoDO.getId());
          }else {
            userInfoDO = userInfoDOList.get(0);
          }
        }else {
          userInfoDO = new UserInfoDO();
          userInfoDO.setOpenId(openId);
          List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
          userInfoDO = userInfoDOList.get(0);
          openid = openId;
        }
      }
      //将用户信息放入缓存中
      redisUtil.set(openid,userInfoDO,6L,TimeUnit.HOURS);
      String url = webIndexUrl+"?openId="+openid;
      logger.info("==sendRedirect==url="+url);
      response.sendRedirect(url);
    }else{
      response.sendRedirect(webIndexUrl+"?denied=true");
    }
//    return error(RequestCode.none , "用户拒绝获取用户信息");
  }
  @PostMapping(value = "/saveLoginName")
  @ApiOperation(value = "保存用户登录名")
  public ApiResult saveUser(@RequestBody UserInfoDO userInfoDO) {
    userInfoService.saveUserInfo(userInfoDO);
    return success(userInfoDO.getId());
  }
  @GetMapping(value = "/getUserList")
  @ApiOperation(value = "获取用户列表")
  public ApiResult getUserList(UserInfoDO userInfoDO){
    return success(userInfoService.queryUserInfoList(userInfoDO));
  }

  @PostMapping(value = "/login")
  @ApiOperation(value = "登录")
  public ApiResult login(@RequestBody UserInfoDO userInfoDO) {
    if(userInfoDO.getLoginName()==null || "".equals(userInfoDO.getLoginName())) {
      return error(RequestCode.missingParameter_error,"请输入登录账号");
    }
    if(userInfoDO.getPassword()==null || "".equals(userInfoDO.getPassword())) {
      return error(RequestCode.missingParameter_error,"请输入密码");
    }

    List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
    if(userInfoDOList.size()>0) {
      if(MD5Util.MD5Encode(userInfoDO.getPassword(),"utf-8").equals(userInfoDOList.get(0).getPassword())){
        //将登陆信息放入redis缓存，token是UUID和loginName的拼接；有效期是6小时
        String token = CacheKeyPrefix.LOGIN_USERINFO+CacheKeyPrefix.SEPARATOR+ StringEx.newUUID()+"_"+userInfoDO.getLoginName();
        redisUtil.set(token,userInfoDOList.get(0),6L,TimeUnit.HOURS);
        return success(token);
      }
    }
    return error(RequestCode.resNotFind_error,"账号或密码不正确");
  }

  @PostMapping(value = "/logout")
  @ApiOperation(value = "退出登录")
  public ApiResult logout( @RequestHeader String token) {
    UserInfoDO userInfoDO = getUserInfoFromToken(token);
    if(userInfoDO!=null) {
      redisUtil.remove(token);
      return success("退出成功");
    }
    return error(RequestCode.forbid_error);
  }

  @PostMapping(value = "/sendShortMsg/{phone}" )
  @ApiOperation(value = "发送短信验证码")
  public ApiResult sendShortMsg(@RequestHeader String token, @PathVariable(value = "phone") String phone) {
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null){
      return error(RequestCode.Not_Login, "token失效");
    }
    //校验手机号是否合法
    ApiResult result = checkPhone(phone);
    if(RequestCode.success != result.getRt().getStatus()){
      return result;
    }
    //生成随机验证码
    String validateCode = StringEx.random4();
    String text = "【尚果科技】您的验证码是"+validateCode;
    //发送随机验证码到手机
    try{
      logger.info("=============手机号" + phone + "的验证码为：" + text);
      String sendSmsRes = SendShortMessageUtil.sendSms(text, phone);
      logger.info("=============调用短信接口发送验证码的响应内容：" + sendSmsRes);
    }catch(Exception e){
      e.printStackTrace();
      return error(RequestCode.server_error,"发送验证码失败");
    }
    //将手机产生的随机码存放进数据库 如果该手机有记录就更新，没记录就产生一条
    ValidateCodeDO vCode=new ValidateCodeDO();
    vCode.setPhone(phone);
    List<ValidateCodeDO> vList = validateCodeService.queryValidateCodeListByPhone(vCode);
    vCode.setValidateCode(validateCode);
    vCode.setCreateTime(new Date());
    if(vList.size()>0){
      //如果存在  更新
      vCode.setId(vList.get(0).getId());
      validateCodeService.updateByPrimaryKey(vCode);
    }else{
      //如果不存在  插入
      validateCodeService.insert(vCode);
    }
    return success(validateCode);
  }

  /**
   * 校验手机号是否合法
   * @param phone
   * @return
   */
  public ApiResult checkPhone(String phone) {
    if(phone==null || "".equals(phone)){
      return error(RequestCode.forbid_error,"请输入手机号");
    }
    String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(17[0-3,5-8])|(18[0-9]))\\d{8}$";
    Pattern p = Pattern.compile(regExp);
    Matcher m = p.matcher(phone);
    //校验手机号 是否合法
    if(!m.matches()){
      return error(RequestCode.forbid_error,"请输入正确的手机号");
    }
    return success();
  }


  @PostMapping(value = "/checkShortMsg/{phone}/{code}" )
  @ApiOperation(value = "校验短信验证码")
  public ApiResult checkShortMsg(@RequestHeader String token, @PathVariable(value = "phone") String phone, @PathVariable(value = "code") String validateCode) {
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null){
      return error(RequestCode.Not_Login, "token失效");
    }
    //校验手机号是否合法
    ApiResult result = checkPhone(phone);
    if(RequestCode.success != result.getRt().getStatus()){
      return result;
    }

    //将手机产生的随机码存放进数据库 如果该手机有记录就更新，没记录就产生一条
    ValidateCodeDO vCode=new ValidateCodeDO();
    vCode.setPhone(phone);
    List<ValidateCodeDO> vList = validateCodeService.queryValidateCodeListByPhone(vCode);
    if(vList.size()>0){
      //如果存在  对比验证码是否一致
      if(vList.get(0).getValidateCode().equals(validateCode)){
        //验证码有效时间5分钟
        if(System.currentTimeMillis()-vList.get(0).getCreateTime().getTime()<300000){
          return success("验证成功");
        }
      }
    }
    return error(RequestCode.Operate_Tip,"验证码无效");
  }

  @PostMapping(value = "/getUserInfoByUuid")
  @ApiOperation(value = "根据UUID查询用户信息")
  public ApiResult getUserInfoByUuid(@RequestBody UserInfoDO userInfoDO) {
    if(userInfoDO.getUuid()==null || "".equals(userInfoDO.getUuid())) {
      return error(RequestCode.missingParameter_error,"请输入uuid");
    }
    userInfoDO.setCanDeleted(YesNoEnum.N);
    List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
    if(userInfoDOList.size()>0) {
        return success(userInfoDOList.get(0));
    }
    return error(RequestCode.resNotFind_error,"用户不存在");
  }

  @PostMapping(value = "/checkPassword/{password}/{newPassword}" )
  @ApiOperation(value = "校验原始密码是否正确")
  public ApiResult checkPasswordUpdate(@RequestHeader String token, @PathVariable(value = "password") String password, @PathVariable(value = "newPassword") String newPassword) {
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null){
      return error(RequestCode.Not_Login, "token失效");
    }

    if(userInfo.getPassword().equals(MD5Util.MD5Encode(password,"utf-8"))){
      //校验密码
      userInfo.setPassword(MD5Util.MD5Encode(newPassword,"utf-8"));
      userInfoService.updateUserInfo(userInfo);
      redisUtil.remove(CacheKeyPrefix.USER_INFO_ID + userInfo.getId());
      UserInfoDO userInfo1 = userInfoService.getUserInfoById(userInfo.getId());
      redisUtil.set(token,userInfo1,6L,TimeUnit.HOURS);
      return success("更新成功");
    }
    return error(RequestCode.Operate_Tip,"原始密码错误");
  }

  @PostMapping(value = "/login4Merchant")
  @ApiOperation(value = "商家登录")
  public ApiResult login4Merchant(@RequestBody UserInfoDO userInfoDO) {
    if(userInfoDO.getLoginName()==null || "".equals(userInfoDO.getLoginName())) {
      return error(RequestCode.missingParameter_error,"请输入登录账号");
    }
    if(userInfoDO.getPassword()==null || "".equals(userInfoDO.getPassword())) {
      return error(RequestCode.missingParameter_error,"请输入密码");
    }
    //加入商家角色的查询条件
    userInfoDO.setUserRole(UserRoleEnum.MERCHANT);
    List<UserInfoDO> userInfoDOList = userInfoService.queryUserInfoList(userInfoDO);
//    if(userInfoDOList.size()>0) {
//      if(MD5Util.MD5Encode(userInfoDO.getPassword(),"utf-8").equals(userInfoDOList.get(0).getPassword())){
//        //将登陆信息放入redis缓存，token是UUID和loginName的拼接；有效期是6小时
//        String token = CacheKeyPrefix.LOGIN_USERINFO+CacheKeyPrefix.SEPARATOR+ StringEx.newUUID()+"_"+userInfoDO.getLoginName();
//        redisUtil.set(token,userInfoDOList.get(0),6L,TimeUnit.HOURS);
//        return success(token);
//      }
//    }
    return error(RequestCode.Not_Login,"账号或密码不正确");
  }

}



