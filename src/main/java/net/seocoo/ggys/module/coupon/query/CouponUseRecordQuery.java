package net.seocoo.ggys.module.coupon.query;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.coupon.constants.CouponUseRecordStateEnum;

import java.util.Date;

/**
 * 优惠券使用记录Query
 * @author ZengXiaoLiang
 * @date 2018/6/4 16:41
 **/
public class CouponUseRecordQuery extends BaseQuery {
  private Integer merchantId;
  private CouponUseRecordStateEnum state;
  private Integer couponTemplateId;
  private Integer userId;
  /**
   * 优惠券获得开始时间
   */
  private Date gainStartDate;

  /**
   * 优惠券获得结束时间
   */
  private Date gainEndDate;

  /**
   * 优惠券使用开始时间
   */
  private Date usedStartDate;

  /**
   * 优惠券使用结束时间
   */
  private Date usedEndDate;

  public Date getGainStartDate() {
    return gainStartDate;
  }

  public void setGainStartDate(Date gainStartDate) {
    this.gainStartDate = gainStartDate;
  }

  public Date getGainEndDate() {
    return gainEndDate;
  }

  public void setGainEndDate(Date gainEndDate) {
    this.gainEndDate = gainEndDate;
  }

  public Date getUsedStartDate() {
    return usedStartDate;
  }

  public void setUsedStartDate(Date usedStartDate) {
    this.usedStartDate = usedStartDate;
  }

  public Date getUsedEndDate() {
    return usedEndDate;
  }

  public void setUsedEndDate(Date usedEndDate) {
    this.usedEndDate = usedEndDate;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public CouponUseRecordStateEnum getState() {
    return state;
  }

  public void setState(CouponUseRecordStateEnum state) {
    this.state = state;
  }

  public Integer getCouponTemplateId() {
    return couponTemplateId;
  }

  public void setCouponTemplateId(Integer couponTemplateId) {
    this.couponTemplateId = couponTemplateId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
