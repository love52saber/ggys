package net.seocoo.ggys.module.order.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.order.constants.TakeOutTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 外卖订单实体
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:32
 */
public class TakeOutOrderDO implements Serializable {
  private Integer id;

  private String remark;

  private TakeOutTypeEnum takeOutType;

  private BigDecimal deliveryFee;

  private BigDecimal packageFee;

  private Date expectSendDate;

  private String selfGetAddress;

  private Date selfGetDate;

  private String selfGetPhone;

  private String uuid;

  private YesNoEnum canDeleted;

  private static final long serialVersionUID = 1L;

  public TakeOutOrderDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public TakeOutTypeEnum getTakeOutType() {
    return takeOutType;
  }

  public void setTakeOutType(TakeOutTypeEnum takeOutType) {
    this.takeOutType =  takeOutType;
  }

  public BigDecimal getDeliveryFee() {
    return deliveryFee;
  }

  public void setDeliveryFee(BigDecimal deliveryFee) {
    this.deliveryFee = deliveryFee;
  }

  public BigDecimal getPackageFee() {
    return packageFee;
  }

  public void setPackageFee(BigDecimal packageFee) {
    this.packageFee = packageFee;
  }

  public Date getExpectSendDate() {
    return expectSendDate;
  }

  public void setExpectSendDate(Date expectSendDate) {
    this.expectSendDate = expectSendDate;
  }

  public String getSelfGetAddress() {
    return selfGetAddress;
  }

  public void setSelfGetAddress(String selfGetAddress) {
    this.selfGetAddress = selfGetAddress == null ? null : selfGetAddress.trim();
  }

  public Date getSelfGetDate() {
    return selfGetDate;
  }

  public void setSelfGetDate(Date selfGetDate) {
    this.selfGetDate = selfGetDate;
  }

  public String getSelfGetPhone() {
    return selfGetPhone;
  }

  public void setSelfGetPhone(String selfGetPhone) {
    this.selfGetPhone = selfGetPhone == null ? null : selfGetPhone.trim();
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  public YesNoEnum getCanDeleted() {
    return canDeleted;
  }

  public void setCanDeleted(YesNoEnum canDeleted) {
    this.canDeleted = canDeleted;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
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
    TakeOutOrderDO other = (TakeOutOrderDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        && (this.getTakeOutType() == null ? other.getTakeOutType() == null : this.getTakeOutType().equals(other.getTakeOutType()))
        && (this.getDeliveryFee() == null ? other.getDeliveryFee() == null : this.getDeliveryFee().equals(other.getDeliveryFee()))
        && (this.getPackageFee() == null ? other.getPackageFee() == null : this.getPackageFee().equals(other.getPackageFee()))
        && (this.getExpectSendDate() == null ? other.getExpectSendDate() == null : this.getExpectSendDate().equals(other.getExpectSendDate()))
        && (this.getSelfGetAddress() == null ? other.getSelfGetAddress() == null : this.getSelfGetAddress().equals(other.getSelfGetAddress()))
        && (this.getSelfGetDate() == null ? other.getSelfGetDate() == null : this.getSelfGetDate().equals(other.getSelfGetDate()))
        && (this.getSelfGetPhone() == null ? other.getSelfGetPhone() == null : this.getSelfGetPhone().equals(other.getSelfGetPhone()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
        && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
    result = prime * result + ((getTakeOutType() == null) ? 0 : getTakeOutType().hashCode());
    result = prime * result + ((getDeliveryFee() == null) ? 0 : getDeliveryFee().hashCode());
    result = prime * result + ((getPackageFee() == null) ? 0 : getPackageFee().hashCode());
    result = prime * result + ((getExpectSendDate() == null) ? 0 : getExpectSendDate().hashCode());
    result = prime * result + ((getSelfGetAddress() == null) ? 0 : getSelfGetAddress().hashCode());
    result = prime * result + ((getSelfGetDate() == null) ? 0 : getSelfGetDate().hashCode());
    result = prime * result + ((getSelfGetPhone() == null) ? 0 : getSelfGetPhone().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
    return result;
  }
}