package net.seocoo.ggys.module.coupon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.core.exception.EnumNotFoundException;
import net.seocoo.ggys.core.util.JodaDateUtil;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.module.coupon.constants.CouponTemplatePayRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateUseRangEnum;
import net.seocoo.ggys.module.coupon.constants.CouponUseRecordStateEnum;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordInfoDTO;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.exception.CouponException;
import net.seocoo.ggys.module.coupon.query.CouponUseRecordQuery;
import net.seocoo.ggys.module.coupon.service.CouponUseRecordService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 优惠券使用记录Controller
 * @author ZengXiaoLiang
 * @date 2018/6/1 20:34
 **/
//@CrossOrigin
@RestController
@RequestMapping("/h5/coupon")
@Api(description = "优惠券使用记录接口")
public class CouponUseRecordController  extends BaseController{

  @Autowired
  private CouponUseRecordService couponUseRecordService;

  @Autowired
  private RedisUtil redisUtil;

//  @PostMapping("/add")
//  public ApiResult add(@RequestBody CouponTemplateDO record, @RequestHeader String token){
//    UserInfoDO userInfo = this.getUserInfoFromToken(token);
//    this.couponUseRecordService.saveCouponUseRecord(record, userInfo.getId());
//    return success();
//  }

  /**
   * 查询优惠券的领取总数
   * @param couponTemplateId 优惠券模板Id
   * @return 领取总数
   */
  @ApiOperation(value = "优惠券的领取总数")
  @GetMapping(value = "/{couponTemplateId}/useRecordCount")
  public ApiResult countUseRecord(@PathVariable int couponTemplateId){
    CouponUseRecordQuery query = new CouponUseRecordQuery();
    query.setCouponTemplateId(couponTemplateId);
    return success(this.couponUseRecordService.countByQuery(query));
  }

  @ApiOperation(value = "优惠券的领取列表")
  @GetMapping(value = "/useRecordList")
  public ApiResult listUseRecord( CouponUseRecordQuery query){

    if(query.getMerchantId() == null) {
      Integer merchantId = this.getMerchantId4Token();
      if(merchantId != null) {
        query.setMerchantId(merchantId);
      }
    }
    return success(this.couponUseRecordService.listByQuery(query));
  }

  @ApiOperation(value = "我的指定商家可用的优惠券列表")
  @GetMapping(value = "/{merchantId}/{orderType}/{orderFee}/{payType}/myNotUseCouponUseRecords")
  public ApiResult listOwnerNotUseCouponUseRecordByMerchantId(@PathVariable int merchantId, @PathVariable String orderType,
                                                              @PathVariable String payType, @PathVariable BigDecimal orderFee) throws EnumNotFoundException {
    UserInfoDO userInfoDO = this.getUserInfoFromToken(this.getToken());
    CouponUseRecordQuery query = new CouponUseRecordQuery();
    query.setMerchantId(merchantId);
    query.setState(CouponUseRecordStateEnum.NOT_USE);
    query.setUserId(userInfoDO.getId());
    List<CouponUseRecordInfoDTO> dtoList = this.couponUseRecordService.listByNotPageQuery(query);
//    List<CouponUseRecordInfoDTO> couponUseRecordInfoDTOList = new ArrayList<>();
    Iterator<CouponUseRecordInfoDTO> iterator =  dtoList.iterator();
    while (iterator.hasNext()){
      CouponUseRecordInfoDTO dto = iterator.next();
      CouponTemplateUseRangEnum couponTemplateUseRangEnum = CouponTemplateUseRangEnum.convertStr2Enum(orderType);
      if(!dto.getUseRangEnumList().contains(couponTemplateUseRangEnum)){
        iterator.remove();
        continue;
      }
      CouponTemplatePayRangEnum payRangEnum = CouponTemplatePayRangEnum.convertStr2Enum(payType);

      if(!dto.getPayRangEnumList().contains(payRangEnum)){
        iterator.remove();
        continue;
      }

      if(orderFee.compareTo(dto.getUseCondition()) == -1) {
        iterator.remove();
        continue;
      }
    }
    return success(dtoList);
  }

  @ApiOperation(value = "商家单位时间内新增优惠券张数")
  @GetMapping(value = "/countNew")
  public ApiResult countLoginUserNewCouponUseRecord() {
    Integer merchantId = getLoginUserMerchantId();
    CouponUseRecordQuery query = new CouponUseRecordQuery();
    query.setMerchantId(merchantId);
    query.setGainStartDate(JodaDateUtil.getStartDate(new Date()));
    query.setGainEndDate(new Date());
    return success(this.couponUseRecordService.countByQuery(query));
  }

  private Integer getLoginUserMerchantId() {
    Integer merchantId = this.getMerchantId4Token();
    if(merchantId == null) {
      throw new CouponException("商家Id不存在,请确定是否已登录系统或者登录用户是商家用户", RequestCode.Not_Login);
    }
    return merchantId;
  }


  @ApiOperation(value = "商家单位时间内使用优惠券张数")
  @GetMapping(value = "/countUsed")
  public ApiResult countLoginUserUsedCouponUseRecord() {
    Integer merchantId = getLoginUserMerchantId();
    CouponUseRecordQuery query = new CouponUseRecordQuery();
    query.setMerchantId(merchantId);
    query.setUsedStartDate(JodaDateUtil.getStartDate(new Date()));
    query.setUsedEndDate(new Date());
    return success(this.couponUseRecordService.countByQuery(query));
  }

  @ApiOperation(value = "根据状态分页查询我的优惠券列表")
  @GetMapping(value = "/myCouponsByState")
  public ApiResult getMyCoupons(CouponUseRecordQuery query) {
    if(query.getState() == null) {
      throw  new AppException("优惠券使用状态不能为空", RequestCode.Operate_Tip);
    }
    UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());
    query.setUserId(userInfo.getId());
    query.setOrderBy("id desc");
    return success(this.couponUseRecordService.listCouponUseRecordInfoDtoByQuery(query));
  }

  @ApiOperation(value = "领取（再领一张）优惠券")
  @PostMapping(value = "/saveCouponUseRecord")
  public ApiResult saveCouponUseRecord(@RequestBody CouponTemplateDO record) {
    UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());

    this.couponUseRecordService.saveCouponUseRecord(record, userInfo.getId());
    return success("领取成功");
  }
 }
