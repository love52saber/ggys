package net.seocoo.ggys.module.coupon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseController;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.coupon.constants.CouponTemplateStateEnum;
import net.seocoo.ggys.module.coupon.dto.CouponUseRecordInfoDTO;
import net.seocoo.ggys.module.coupon.entity.CouponTemplateDO;
import net.seocoo.ggys.module.coupon.exception.CouponException;
import net.seocoo.ggys.module.coupon.form.CouponTemplateForm;
import net.seocoo.ggys.module.coupon.query.CouponTemplateQuery;
import net.seocoo.ggys.module.coupon.service.CouponTemplateService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 优惠券模板Controller
 *
 * @author ZengXiaoLiang
 * @date 2018/5/30 17:03
 **/
//@CrossOrigin
@RestController
@RequestMapping("/h5/coupon")
@Api(description = "优惠券接口")
public class CouponTemplateController extends BaseController {

  @Autowired
  private CouponTemplateService couponTemplateService;

  @GetMapping(value = "/list")
  public ApiResult listByMerchantId(CouponTemplateQuery query) {
    if (query.getMerchantId() == null) {
      Integer merchantId = getLoginUserMerchantId();
      query.setMerchantId(merchantId);
    }
    PageBean<CouponTemplateDO> couponTemplateDOPageBean = couponTemplateService.listByPageQuery(query);
    return success(couponTemplateDOPageBean);
  }

  @PostMapping(value = "/add")
  @ApiOperation(value = "新增优惠券模板")
  public ApiResult addCouponTemplate(@RequestBody @Validated CouponTemplateForm form) {
    if (form.getMerchantId() == null) {
      Integer merchantId = getLoginUserMerchantId();
      form.setMerchantId(merchantId);
    }
    CouponTemplateDO record = new CouponTemplateDO();
    record.setUseRang(0);
    record.setPayRang(0);
    form.getPayRangList().forEach(payRangEnum -> record.setPayRang(record.getPayRang() + payRangEnum.getCode()));
    form.getUseRangList().forEach(useRangEnum -> record.setUseRang(record.getUseRang() + useRangEnum.getCode()));
    BeanUtils.copyProperties(form, record);

    this.couponTemplateService.saveCouponTemplate(record);
    return success();
  }

  private Integer getLoginUserMerchantId() {
    Integer merchantId = this.getMerchantId4Token();
    if (merchantId == null) {
      throw new CouponException("商家Id不存在,请确定是否是商户,并且已登录系统", RequestCode.Not_Login);
    }
    return merchantId;
  }

  @PostMapping(value = "/updateState")
  public ApiResult updateCouponTemplateState(@RequestBody CouponTemplateForm form) {
    CouponTemplateDO record = new CouponTemplateDO();
    BeanUtils.copyProperties(form, record);
    this.couponTemplateService.updateState(record);
    return success();
  }

  @GetMapping(value = "/{id}")
  public ApiResult get(@PathVariable int id) {
    return success(this.couponTemplateService.getCouponTemplateById(id));
  }

  @DeleteMapping(value = "/{id}")
  public ApiResult delete(@PathVariable int id) {
    this.couponTemplateService.deleteCouponTemplate(id);
    return success();
  }

  @ApiOperation(value = "商家好券接口")
  @GetMapping(value = "/listReceiveCoupon")
  public ApiResult listReceiveCoupon(CouponTemplateQuery query) {
    // TODO 此处是不是也应该根据距离查询商家优惠券
    UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());
    query.setState(CouponTemplateStateEnum.PUBLISH);
    query.setCanUseCount(0);
    PageBean<CouponUseRecordInfoDTO> listReceiveCoupon = this.couponTemplateService.listReceiveCoupon(query, userInfo);
    return success(listReceiveCoupon);

  }

 /* @PostMapping(value = "/update")
  @ApiModelProperty(value = "编辑优惠券模板")
  public ApiResult updateCouponTemplate(@RequestBody CouponTemplateForm form) {
    CouponTemplateDO record = new CouponTemplateDO();
    record.setUseRang(0);
    record.setPayRang(0);
    form.getPayRangList().forEach(payRangEnum -> record.setPayRang(record.getPayRang() + payRangEnum.getCode()));
    form.getUseRangList().forEach(useRangEnum -> record.setUseRang(record.getUseRang() + useRangEnum.getCode()));
    this.couponTemplateService.updateState(record);
    return success();
  }*/
}
