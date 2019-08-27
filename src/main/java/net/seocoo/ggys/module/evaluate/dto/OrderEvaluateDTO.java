package net.seocoo.ggys.module.evaluate.dto;

import net.seocoo.ggys.module.evaluate.constants.OrderEvaluateResultEnum;
import net.seocoo.ggys.module.order.constants.OrderPayTypeEnum;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * @author PanChengHao
 * @date 2018/6/20 11:32
 */
public class OrderEvaluateDTO {

  //订单id
  private Integer orderId;

  //评价id
  private Integer evaluateId;

  //订单编号
  private String orderNo;

  //用户昵称
  private String nickname;

  //商品名称
  private String goodsName;

  //订单费用
  private BigDecimal orderFee;

  //优惠券费用
  private BigDecimal orderCouponFee;

  //实际支付费用
  private BigDecimal orderActualFee;

  //订单支付类型
  private OrderPayTypeEnum payType;

  //订单类型
  private OrderTypeEnum orderType;

  //订单状态
  private OrderStateEnum orderState;

  //评价结果
  private OrderEvaluateResultEnum evaluateResult;

  //评价具体内容
  private String content;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getEvaluateId() {
    return evaluateId;
  }

  public void setEvaluateId(Integer evaluateId) {
    this.evaluateId = evaluateId;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public BigDecimal getOrderFee() {
    return orderFee;
  }

  public void setOrderFee(BigDecimal orderFee) {
    this.orderFee = orderFee;
  }

  public BigDecimal getOrderCouponFee() {
    return orderCouponFee;
  }

  public void setOrderCouponFee(BigDecimal orderCouponFee) {
    this.orderCouponFee = orderCouponFee;
  }

  public BigDecimal getOrderActualFee() {
    return orderActualFee;
  }

  public void setOrderActualFee(BigDecimal orderActualFee) {
    this.orderActualFee = orderActualFee;
  }

  public OrderPayTypeEnum getPayType() {
    return payType;
  }

  public void setPayType(OrderPayTypeEnum payType) {
    this.payType = payType;
  }

  public OrderTypeEnum getOrderType() {
    return orderType;
  }

  public void setOrderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
  }

  public OrderStateEnum getOrderState() {
    return orderState;
  }

  public void setOrderState(OrderStateEnum orderState) {
    this.orderState = orderState;
  }

  public OrderEvaluateResultEnum getEvaluateResult() {
    return evaluateResult;
  }

  public void setEvaluateResult(OrderEvaluateResultEnum evaluateResult) {
    this.evaluateResult = evaluateResult;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
