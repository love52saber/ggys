package net.seocoo.ggys.module.coupon.entity;

import net.seocoo.ggys.module.coupon.constants.CouponUseRecordStateEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券使用记录DO
 *
 * @author: ZengXiaoLiang
 * @date: 2018/5/29 14:28
 */
public class CouponUseRecordDO implements Serializable {
  private Integer id;

  private CouponUseRecordStateEnum state;

  private Date usedDate;

  private Date getDate;

  private Integer userId;

  private Integer merchantId;

  private Integer couponTemplateId;

  private String uuid;

  private Integer orderId;

  private static final long serialVersionUID = 1L;

  public CouponUseRecordDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 优惠券使用记录状态
   * @return 优惠券使用记录状态
   */
  public CouponUseRecordStateEnum getState() {
    return state;
  }

  /**
   * 优惠券使用记录状态
   * @param state 优惠券使用记录状态
   */
  public void setState(CouponUseRecordStateEnum state) {
    this.state = state;
  }

  /**
   * 使用时间
   * @return 使用时间
   */
  public Date getUsedDate() {
    return usedDate;
  }

  /**
   * 使用时间
   * @param usedDate 使用时间
   */
  public void setUsedDate(Date usedDate) {
    this.usedDate = usedDate;
  }

  /**
   * 优惠券获得时间
   * @return 优惠券获得时间
   */
  public Date getGetDate() {
    return getDate;
  }

  /**
   * 优惠券获得时间
   * @param getDate 优惠券获得时间
   */
  public void setGetDate(Date getDate) {
    this.getDate = getDate;
  }

  /**
   * 优惠券使用人
   * @return 优惠券使用人
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * 优惠券使用人
   * @param userId 优惠券使用人
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * 优惠券所属商家
   * @return 优惠券所属商家
   */
  public Integer getMerchantId() {
    return merchantId;
  }

  /**
   * 优惠券所属商家
   * @param merchantId 优惠券所属商家
   */
  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  /**
   * 优惠券模板Id
   * @return 优惠券模板Id
   */
  public Integer getCouponTemplateId() {
    return couponTemplateId;
  }

  /**
   * 优惠券模板Id
   * @param couponTemplateId 优惠券模板Id
   */
  public void setCouponTemplateId(Integer couponTemplateId) {
    this.couponTemplateId = couponTemplateId;
  }

  /**
   * UUID
   * @return UUID
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * UUID
   * @param uuid UUID
   */
  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  /**
   * 订单Id
   * @return 订单Id
   */
  public Integer getOrderId() {
    return orderId;
  }

  /**
   * 订单Id
   * @param orderId 订单Id
   */
  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    CouponUseRecordDO other = (CouponUseRecordDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
        && (this.getUsedDate() == null ? other.getUsedDate() == null : this.getUsedDate().equals(other.getUsedDate()))
        && (this.getGetDate() == null ? other.getGetDate() == null : this.getGetDate().equals(other.getGetDate()))
        && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
        && (this.getCouponTemplateId() == null ? other.getCouponTemplateId() == null : this.getCouponTemplateId().equals(other.getCouponTemplateId()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
        && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
    result = prime * result + ((getUsedDate() == null) ? 0 : getUsedDate().hashCode());
    result = prime * result + ((getGetDate() == null) ? 0 : getGetDate().hashCode());
    result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
    result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
    result = prime * result + ((getCouponTemplateId() == null) ? 0 : getCouponTemplateId().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
    return result;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}