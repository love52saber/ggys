package net.seocoo.ggys.module.order.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.order.constants.OrderPayTypeEnum;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单基类DO
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:30
 */
public class MerchantBaseOrderDO implements Serializable {
  private Integer id;



  private String orderNo;

  private Date orderDate;

  private BigDecimal orderFee;

  private BigDecimal orderActualFee;

  private OrderPayTypeEnum payType;

  private Integer finishedUserId;

  private Date finishedDate;

  private OrderTypeEnum orderType;

  private Date payDate;

  private OrderStateEnum orderState;

  private BigDecimal orderPayActualFee;

  private BigDecimal orderCouponFee;

  private String transactionNo;

  private Integer orderUserId;

  private Integer merchantId;

  private Integer takeOutOrderId;

  private Integer grouponOrderId;

  @JSONField(serialize = false)
  private String uuid;

  @JSONField(serialize = false)
  private YesNoEnum canDeleted;

  private static final long serialVersionUID = 1L;

  public MerchantBaseOrderDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 订单编号
   * @return 订单编号
   */
  public String getOrderNo() {
    return orderNo;
  }

  /**
   * 订单编号
   * @param orderNo 订单编号
   */
  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo == null ? null : orderNo.trim();
  }

  /**
   * 下单时间
   * @return 下单时间
   */
  public Date getOrderDate() {
    return orderDate;
  }

  /**
   * 下单时间
   * @param orderDate 下单时间
   */
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  /**
   * 订单优惠前费用
   * @return 订单优惠前费用
   */
  public BigDecimal getOrderFee() {
    return orderFee;
  }

  /**
   * 订单优惠前费用
   * @param orderFee 订单优惠前费用
   */
  public void setOrderFee(BigDecimal orderFee) {
    this.orderFee = orderFee;
  }

  /**
   * 订单实际费用
   * @return 订单实际费用
   */
  public BigDecimal getOrderActualFee() {
    return orderActualFee;
  }

  /**
   * 订单实际费用
   * @param orderActualFee 订单实际费用
   */
  public void setOrderActualFee(BigDecimal orderActualFee) {
    this.orderActualFee = orderActualFee;
  }

  /**
   * 支付类型
   * @return 支付类型
   */
  public OrderPayTypeEnum getPayType() {
    return payType;
  }

  /**
   * 支付类型
   * @param payType 支付类型
   */
  public void setPayType(OrderPayTypeEnum payType) {
    this.payType = payType;
  }

  /**
   * 订单完成人
   * @return 订单完成人
   */
  public Integer getFinishedUserId() {
    return finishedUserId;
  }

  /**
   * 订单完成人
   * @param finishedUserId 订单完成人
   */
  public void setFinishedUserId(Integer finishedUserId) {
    this.finishedUserId = finishedUserId;
  }

  /**
   * 订单完成时间
   * @return 订单完成时间
   */
  public Date getFinishedDate() {
    return finishedDate;
  }

  /**
   * 订单完成时间
   * @param finishedDate 订单完成时间
   */
  public void setFinishedDate(Date finishedDate) {
    this.finishedDate = finishedDate;
  }

  /**
   * 订单类型
   * @return 订单类型
   */
  public OrderTypeEnum getOrderType() {
    return orderType;
  }

  /**
   * 订单类型
   * @param orderType 订单类型
   */
  public void setOrderType(OrderTypeEnum orderType) {
    this.orderType  = orderType;
  }

  /**
   * 支付时间
   * @return 支付时间
   */
  public Date getPayDate() {
    return payDate;
  }

  /**
   * 支付时间
   * @param payDate 支付时间
   */
  public void setPayDate(Date payDate) {
    this.payDate = payDate;
  }

  /**
   * 订单状态
   * @return 订单状态
   */
  public OrderStateEnum getOrderState() {
    return orderState;
  }

  /**
   * 订单状态
   * @param orderState 订单状态
   */
  public void setOrderState(OrderStateEnum orderState) {
    this.orderState = orderState;
  }

  /**
   * 订单状态
   * @return 订单状态
   */
  public BigDecimal getOrderPayActualFee() {
    return orderPayActualFee;
  }

  /**
   * 订单实际支付费用
   * @param orderPayActualFee 订单实际支付费用
   */
  public void setOrderPayActualFee(BigDecimal orderPayActualFee) {
    this.orderPayActualFee = orderPayActualFee;
  }

  /**
   * 订单实际支付费用
   * @return 订单实际支付费用
   */
  public BigDecimal getOrderCouponFee() {
    return orderCouponFee;
  }

  /**
   * 订单优惠费用
   * @param orderCouponFee 订单优惠费用
   */
  public void setOrderCouponFee(BigDecimal orderCouponFee) {
    this.orderCouponFee = orderCouponFee;
  }

  /**
   * 支付交易号
   * @return 支付交易号
   */
  public String getTransactionNo() {
    return transactionNo;
  }

  /**
   * 支付交易号
   * @param transactionNo 支付交易号
   */
  public void setTransactionNo(String transactionNo) {
    this.transactionNo = transactionNo == null ? null : transactionNo.trim();
  }

  /**
   * 下单人
   * @return 下单人
   */
  public Integer getOrderUserId() {
    return orderUserId;
  }

  /**
   * 下单人
   * @param orderUserId 下单人
   */
  public void setOrderUserId(Integer orderUserId) {
    this.orderUserId = orderUserId;
  }

  /**
   * 订单所属商家Id
   * @return 订单所属商家Id
   */
  public Integer getMerchantId() {
    return merchantId;
  }

  /**
   * 订单所属商家Id
   * @param merchantId 订单所属商家Id
   */
  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  /**
   * 外卖订单Id
   * @return 外卖订单Id
   */
  public Integer getTakeOutOrderId() {
    return takeOutOrderId;
  }

  /**
   * 外卖订单Id
   * @param takeOutOrderId 外卖订单Id
   */
  public void setTakeOutOrderId(Integer takeOutOrderId) {
    this.takeOutOrderId = takeOutOrderId;
  }

  /**
   * 团购订单Id
   * @return 团购订单Id
   */
  public Integer getGrouponOrderId() {
    return grouponOrderId;
  }

  /**
   * 团购订单Id
   * @param grouponOrderId 团购订单Id
   */
  public void setGrouponOrderId(Integer grouponOrderId) {
    this.grouponOrderId = grouponOrderId;
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
    MerchantBaseOrderDO other = (MerchantBaseOrderDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
        && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
        && (this.getOrderFee() == null ? other.getOrderFee() == null : this.getOrderFee().equals(other.getOrderFee()))
        && (this.getOrderActualFee() == null ? other.getOrderActualFee() == null : this.getOrderActualFee().equals(other.getOrderActualFee()))
        && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
        && (this.getFinishedUserId() == null ? other.getFinishedUserId() == null : this.getFinishedUserId().equals(other.getFinishedUserId()))
        && (this.getFinishedDate() == null ? other.getFinishedDate() == null : this.getFinishedDate().equals(other.getFinishedDate()))
        && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
        && (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
        && (this.getOrderState() == null ? other.getOrderState() == null : this.getOrderState().equals(other.getOrderState()))
        && (this.getOrderPayActualFee() == null ? other.getOrderPayActualFee() == null : this.getOrderPayActualFee().equals(other.getOrderPayActualFee()))
        && (this.getOrderCouponFee() == null ? other.getOrderCouponFee() == null : this.getOrderCouponFee().equals(other.getOrderCouponFee()))
        && (this.getTransactionNo() == null ? other.getTransactionNo() == null : this.getTransactionNo().equals(other.getTransactionNo()))
        && (this.getOrderUserId() == null ? other.getOrderUserId() == null : this.getOrderUserId().equals(other.getOrderUserId()))
        && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
        && (this.getTakeOutOrderId() == null ? other.getTakeOutOrderId() == null : this.getTakeOutOrderId().equals(other.getTakeOutOrderId()))
        && (this.getGrouponOrderId() == null ? other.getGrouponOrderId() == null : this.getGrouponOrderId().equals(other.getGrouponOrderId()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
        && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
    result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
    result = prime * result + ((getOrderFee() == null) ? 0 : getOrderFee().hashCode());
    result = prime * result + ((getOrderActualFee() == null) ? 0 : getOrderActualFee().hashCode());
    result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
    result = prime * result + ((getFinishedUserId() == null) ? 0 : getFinishedUserId().hashCode());
    result = prime * result + ((getFinishedDate() == null) ? 0 : getFinishedDate().hashCode());
    result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
    result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
    result = prime * result + ((getOrderState() == null) ? 0 : getOrderState().hashCode());
    result = prime * result + ((getOrderPayActualFee() == null) ? 0 : getOrderPayActualFee().hashCode());
    result = prime * result + ((getOrderCouponFee() == null) ? 0 : getOrderCouponFee().hashCode());
    result = prime * result + ((getTransactionNo() == null) ? 0 : getTransactionNo().hashCode());
    result = prime * result + ((getOrderUserId() == null) ? 0 : getOrderUserId().hashCode());
    result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
    result = prime * result + ((getTakeOutOrderId() == null) ? 0 : getTakeOutOrderId().hashCode());
    result = prime * result + ((getGrouponOrderId() == null) ? 0 : getGrouponOrderId().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
    return result;
  }
}