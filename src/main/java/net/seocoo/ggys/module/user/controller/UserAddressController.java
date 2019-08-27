package net.seocoo.ggys.module.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.user.entity.UserAddressDO;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.form.UserAddressForm;
import net.seocoo.ggys.module.user.service.UserAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * 收货地址
 * @author wangpan
 * @date 2018/6/7 16:19
 */
//@CrossOrigin
@RestController
@RequestMapping(value = ("/address"))
@Api( value = "收货地址接口", description="收货地址接口")
public class UserAddressController extends BaseController {

  @Autowired
  private UserAddressService userAddressService;

  /**
   * 添加收货地址
   * @param userAddressForm
   * @return
   */
  @PostMapping(value = "/add")
  @Transactional(rollbackFor = Exception.class)
  @ApiOperation(value = "添加收货地址")
  public ApiResult addAddress(@RequestBody UserAddressForm userAddressForm, @RequestHeader String token){
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null) {
      return error(RequestCode.missingParameter_error,"用户token已过期");
    }
    //获取用户的id
    userAddressForm.setUserId(userInfo.getId());
    //校验必传的用户信息
    ApiResult checkResult = checkUserAddressParams(userAddressForm);
    if(checkResult.getRt().getStatus()!=RequestCode.success){
      return checkResult;
    }
    //没有输入的情况 设置为非默认
    if(userAddressForm.getCanDefaultAddress()==null){
      userAddressForm.setCanDefaultAddress(YesNoEnum.N);
    }
    UserAddressDO userAddressDO = new UserAddressDO();
    BeanUtils.copyProperties(userAddressForm,userAddressDO);
    //校验本次地址是否是默认的
    YesNoEnum canDefaultAddress = userAddressDO.getCanDefaultAddress();
    if(canDefaultAddress != null && YesNoEnum.Y.equals(canDefaultAddress)) {
      //是默认的，需要修改此用户其他的地址为非默认
      updateNotDefaultByUserId(userAddressDO.getUserId());
    }
    userAddressService.saveUserAddress(userAddressDO);
    return success();
  }

  /**
   * 校验收货地址必传参数
   * @param userAddressForm
   * @return
   */
  public ApiResult checkUserAddressParams(UserAddressForm userAddressForm){
    if(userAddressForm.getFullName()==null) {
      return error(RequestCode.missingParameter_error,"请输入收货人姓名");
    }
    if(userAddressForm.getPhone()==null) {
      return error(RequestCode.missingParameter_error,"请输入收货人电话");
    }
    if(userAddressForm.getProvince()==null) {
      return error(RequestCode.missingParameter_error,"请输入收货人省份");
    }
    if(userAddressForm.getCity()==null) {
      return error(RequestCode.missingParameter_error,"请输入收货人城市");
    }
    if(userAddressForm.getCounty()==null) {
      return error(RequestCode.missingParameter_error,"请输入收货人区县");
    }
    if(userAddressForm.getAddress()==null) {
      return error(RequestCode.missingParameter_error,"请输入收货人详细地址");
    }
    return success();
  }

  /**
   * 根据用户id将所有的地址更新为非默认地址
   * @param userId
   */
  public void updateNotDefaultByUserId(int userId) {
    UserAddressDO userAddress = new UserAddressDO();
    userAddress.setUserId(userId);
    userAddressService.updateNotDefaultByUserId(userAddress);
  }

  /**
   * 假删除
   */
  @ApiOperation(value = "删除此条收货地址")
  @PostMapping(value = "/delete/{id}")
  public ApiResult delete(@PathVariable("id") Integer id,@RequestHeader String token){
    UserInfoDO userInfoDO = getUserInfoFromToken(token);
    if(userInfoDO==null){
      return error(RequestCode.Not_Login,"登陆token失效");
    }
    userAddressService.deleteById(id);
    return success("删除成功");
  }

  /**
   * 查询当前登录人的收货地址列表
   * @param token
   * @return
   */
  @GetMapping(value = "/list")
  @ApiOperation(value = "查询收货地址列表")
  public ApiResult getAddressList(@RequestHeader String token){
    UserInfoDO userInfoDO = getUserInfoFromToken(token);
    int id = userInfoDO.getId();
    List<UserAddressDO> userAddressDOList = userAddressService.queryAddressListByUserId(id);
    return success(userAddressDOList);
  }

  @Transactional( rollbackFor = Exception.class)
  @PostMapping(value = "/setDefault/{id}")
  @ApiOperation("设置为默认地址")
  public ApiResult setDefaultAddress(@RequestHeader String token,@ApiParam(value = "收货地址的id") @PathVariable("id") Integer id){
    UserInfoDO userInfoDO = getUserInfoFromToken(token);
    if(userInfoDO==null){
      return error(RequestCode.Not_Login,"登陆token失效");
    }
    int userId = userInfoDO.getId();
    //将此用户的其他的地址修改为非默认
    updateNotDefaultByUserId(userId);
    //将此地址修改为默认
    UserAddressDO userAddress = new UserAddressDO();
    userAddress.setId(id);
    userAddress.setCanDefaultAddress(YesNoEnum.Y);
    userAddress.setUpdateDate(new Date());
    userAddressService.updateByPrimaryKeySelective(userAddress);
    return success();
  }

  @PostMapping(value = "/get/{id}")
  @ApiOperation(value = "获取地址详情")
  public ApiResult getAddress(@RequestHeader String token,@ApiParam(value = "收货地址的id") @PathVariable("id") Integer id){
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null){
      return error(RequestCode.Not_Login,"登陆token失效");
    }
    UserAddressDO userAddress = new UserAddressDO();
    userAddress.setId(id);
    userAddress = userAddressService.selectByPrimaryKey(id);
    return success(userAddress);
  }

  @PostMapping(value = "/edit")
  @ApiOperation(value = "保存编辑的地址")
  public ApiResult editAddress(@RequestHeader String token, @RequestBody UserAddressForm userAddressForm){
    UserInfoDO userInfo = getUserInfoFromToken(token);
    if(userInfo==null){
      return error(RequestCode.Not_Login,"登陆token失效");
    }
    if(userAddressForm.getId()==null){
      return error(RequestCode.forbid_error,"请输入id");
    }
    if(userAddressForm.getUserId()==null){
      userAddressForm.setUserId(userInfo.getId());
    }
    //校验必传的用户信息
    ApiResult checkResult = checkUserAddressParams(userAddressForm);
    if(checkResult.getRt().getStatus()!=RequestCode.success){
      return checkResult;
    }
    UserAddressDO userAddress = new UserAddressDO();
    BeanUtils.copyProperties(userAddressForm,userAddress);
    System.out.println(userAddress.toString());
    userAddress.setUpdateDate(new Date());
    userAddressService.updateByPrimaryKeySelective(userAddress);
    return success();
  }

}
