package net.seocoo.ggys.module.area.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.util.PropertiesUtils;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.core.util.map.HttpUtil;
import net.seocoo.ggys.core.util.map.LocationUtil;
import net.seocoo.ggys.core.wechat.AccessToken;
import net.seocoo.ggys.core.wechat.CreateAccessTokenUtil;
import net.seocoo.ggys.core.wechat.WeixinUtil;
import net.seocoo.ggys.module.area.constants.LevelEnum;
import net.seocoo.ggys.module.area.entity.AreaDO;
import net.seocoo.ggys.module.area.service.AreaService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.exception.UserInfoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wangpan
 * @date 2018/6/12 21:01
 */
@RestController
//@CrossOrigin
@Api(value = "地理位置",description = "地理位置接口")
@RequestMapping(value = "/location")
public class LocationController extends BaseController {


  String mapKey =PropertiesUtils.getGaoDeMap().getProperty("GeoDe.Key");

  @Value("${rest.map.api.url}")
  String restMapUrl;

  @Value("${systemConfig.appId}")
  private String appId;

  @Value("${systemConfig.appSecret}")
  private String appSecret;

  @Autowired
  private RedisUtil redisUtil;

//  @Value("${web.visit.url}")
//  private String webVisitUrl;

  @Autowired
  private AreaService areaService;

  @PostMapping(value = "/getSignature")
  @ApiOperation(value = "获取微信签名参数，给jsapi调用")
  public ApiResult getSignature ( String currentUrl){
    String accessToken = createAccessToken(appId,appSecret);
    logger.info("==LocationController======accessToken=="+accessToken+"--currentUrl="+currentUrl);
    String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
    JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
    logger.info("--------jsonObject=="+jsonObject);
    String ticket = jsonObject.getString("ticket");

    long timestamp = System.currentTimeMillis()/1000;
    String nonceStr = StringEx.randomByNum(6);

    String signature = "";
    //注意这里参数名必须全部小写，且必须有序
    String string1 = "jsapi_ticket=" + ticket +
        "&noncestr=" + nonceStr +
        "&timestamp=" + timestamp +
        "&url=" +currentUrl;

    logger.info("#######################拼接参数###################string1="+string1);
    try{
      MessageDigest crypt = MessageDigest.getInstance("SHA-1");
      crypt.reset();
      crypt.update(string1.getBytes("UTF-8"));
      signature = byteToHex(crypt.digest());
    }catch(Exception e){
      e.printStackTrace();
    }
    logger.info("#######################签名参数###################signature="+signature);
    Map map = new HashMap<>(5);
    map.put("timestamp",timestamp);
    map.put("nonceStr",nonceStr);
    map.put("signature",signature);
    map.put("url",currentUrl);
    map.put("appId",appId);
    return success(map);
  }

  /**
   * 根据appId和appSecret 生成access_token
   * @param appId
   * @param appSecret
   * @return
   */
  public  synchronized String createAccessToken(String appId,String appSecret){
    String access_token =null;
    try {
      //根据APPId和appSecret查询缓存中的微信token
      String wxAccessToken = (String) redisUtil.get("wxAccessToken");
      if(wxAccessToken!=null && !"".equals(wxAccessToken)){
        access_token = wxAccessToken;
      }else {
        logger.info("==========createAccessToken===accessToken is expired , reCreate now");
        //已过期，重新获取
        AccessToken newAccessToken = CreateAccessTokenUtil.getAccessToken(appId, appSecret);
        logger.info("==========createAccessToken===newAccessToken=="+newAccessToken);
        if(newAccessToken!=null){
          access_token = newAccessToken.getAccessToken();
          redisUtil.set("wxAccessToken",access_token,2L,TimeUnit.HOURS);
          logger.info("=====new==access_token="+access_token);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return access_token;
  }

  @GetMapping(value = "/{lat}/{lon:.*}")
  @ApiOperation(value = "根据经纬度获取地理位置信息")
  public ApiResult getLocation0(@PathVariable("lat") double lat,@PathVariable("lon") double lon,@RequestHeader String token){
    System.out.println("lat="+lat+";lon="+lon);
//    double lat = 31.865322;
//    double lon = 117.280914;
    String locationStr = LocationUtil.transform2Str(lat,lon);
    System.out.println(locationStr);
    //将经纬度信息放入用户的缓存信息中
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if (userInfo ==null){
      throw new UserInfoException("token失效，请先登陆",RequestCode.Not_Login);
    }
    String[] locations = locationStr.split(",");
    userInfo.setLng(Double.parseDouble(locations[0]));
    userInfo.setLat(Double.parseDouble(locations[1]));
    redisUtil.set(token,userInfo,6L,TimeUnit.HOURS);
//    String param = "key="+mapKey+"&location="+locationStr;
//    String responseStr = HttpUtil.sendGet(restMapUrl,param);
    String responseStr = LocationUtil.getLocationInfo(locations[1],locations[0]);
    JSONObject res = JSONObject.parseObject(responseStr);
    String status = res.getString("status");
    //返回成功
    if("1".equals(status)){
      JSONObject regeocode =res.getJSONObject("regeocode");
      JSONObject addressComponent =regeocode.getJSONObject("addressComponent");
      String cityCode = addressComponent.getString("citycode");
      String adCode = addressComponent.getString("adcode");
      //根据cityCode 和 adCode分别查询数据库中对应的id
      AreaDO area = new AreaDO();
      area.setCityCode(cityCode);
      area.setLevel(LevelEnum.city);
      List<AreaDO> areaList = areaService.queryAreaList(area);
      if(areaList.size()>0){
        //将城市的id存入用户缓存
        userInfo.setCityId(areaList.get(0).getId());
      }
      area.setAreaDistrictCode(adCode);
      area.setLevel(LevelEnum.district);
      List<AreaDO> areaList1 = areaService.queryAreaList(area);
      if(areaList1.size()>0){
        //将区县的id存入用户缓存
        userInfo.setDistrictId(areaList1.get(0).getId());
      }
      logger.info("cityCode="+cityCode+";AreaDistrictCode="+adCode);
    }
    redisUtil.set(token,userInfo,6L,TimeUnit.HOURS);
    return success(responseStr);
  }
  @GetMapping(value = "/lat")
  @ApiOperation(value = "根据经纬度获取地理位置信息")
  public ApiResult getLocation(Double lat, Double lon){
    System.out.println("lat="+lat+";;lon="+lon);
//    double lat = 31.865322;
//    double lon = 117.280914;
    String locationStr = LocationUtil.transform2Str(lat,lon);
    System.out.println(locationStr);
//    String url = "http://restapi.amap.com/v3/geocode/regeo";
    String param = "key="+mapKey+"&location="+locationStr;
    String responseStr = HttpUtil.sendGet(restMapUrl,param);
    System.out.println("responseStr==="+responseStr);
    return success(responseStr);
  }

  /**
   * 随机加密
   * @param hash
   * @return
   */
  private static String byteToHex(final byte[] hash) {
    Formatter formatter = new Formatter();
    for (byte b : hash) {
      formatter.format("%02x", b);
    }
    String result = formatter.toString();
    formatter.close();
    return result;
  }

}
