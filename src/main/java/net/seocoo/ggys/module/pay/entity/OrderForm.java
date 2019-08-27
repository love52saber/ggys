package net.seocoo.ggys.module.pay.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 支付订单
 * @author wangpan
 * @date 2018/6/15 15:31
 */
@ApiModel(value = "订单支付 表单")
public class OrderForm implements Serializable {

  /**
   * 订单号
   */
  @ApiModelProperty(value = "订单号")
  @JSONField(name = "orderNo")
  private String orderNumber;

  /**
   * 下单日期
   */
  @ApiModelProperty(value = "下单日期")
  @JSONField(name = "orderDate")
  private Date transTime;

  /**
   * 支付类型
   */
  @ApiModelProperty(value = "支付类型")
  private String payType;

  /**
   * 支付日期
   */
  @ApiModelProperty(value = "支付日期")
  private Date payDate;

  /**
   * 交易金额
   */
  @ApiModelProperty(value = "交易金额")
  @JSONField(name = "orderPayActualFee")
  private BigDecimal amount;

  /**
   * 交易总金额
   */
  @ApiModelProperty(value = "交易总金额")
  @JSONField(name = "orderPayActualTotalFee")
  private BigDecimal totalAmount;

  /**
   * 交易流水号
   */
  @ApiModelProperty(value = "交易流水号")
  @JSONField(name = "transactionNo")
  private String orderSeq;

  /**
   * 微信code
   */
  @ApiModelProperty(value = "微信code")
  private String wxCode;

  /**
   * 商户id
   */
  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  /**
   * 商户code
   */
  @ApiModelProperty(value = "商户编码")
  private String merchantCode;

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getTransTime() {
    return transTime;
  }

  public void setTransTime(Date transTime) {
    this.transTime = transTime;
  }

  public String getPayType() {
    return payType;
  }

  public void setPayType(String payType) {
    this.payType = payType;
  }

  public Date getPayDate() {
    return payDate;
  }

  public void setPayDate(Date payDate) {
    this.payDate = payDate;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getOrderSeq() {
    return orderSeq;
  }

  public void setOrderSeq(String orderSeq) {
    this.orderSeq = orderSeq;
  }

  public String getWxCode() {
    return wxCode;
  }

  public void setWxCode(String wxCode) {
    this.wxCode = wxCode;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public String getMerchantCode() {
    return merchantCode;
  }

  public void setMerchantCode(String merchantCode) {
    this.merchantCode = merchantCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderForm orderForm = (OrderForm) o;
    return Objects.equals(orderNumber, orderForm.orderNumber) &&
        Objects.equals(transTime, orderForm.transTime) &&
        Objects.equals(payType, orderForm.payType) &&
        Objects.equals(payDate, orderForm.payDate) &&
        Objects.equals(amount, orderForm.amount) &&
        Objects.equals(totalAmount, orderForm.totalAmount) &&
        Objects.equals(orderSeq, orderForm.orderSeq) &&
        Objects.equals(wxCode, orderForm.wxCode) &&
        Objects.equals(merchantId, orderForm.merchantId) &&
        Objects.equals(merchantCode, orderForm.merchantCode);
  }

  @Override
  public int hashCode() {

    return Objects.hash(orderNumber, transTime, payType, payDate, amount, totalAmount, orderSeq, wxCode, merchantId, merchantCode);
  }

  @Override
  public String toString() {
    return "OrderForm{" +
        "orderNumber='" + orderNumber + '\'' +
        ", transTime=" + transTime +
        ", payType='" + payType + '\'' +
        ", payDate=" + payDate +
        ", amount=" + amount +
        ", totalAmount=" + totalAmount +
        ", orderSeq='" + orderSeq + '\'' +
        ", wxCode='" + wxCode + '\'' +
        ", merchantId=" + merchantId +
        ", merchantCode='" + merchantCode + '\'' +
        '}';
  }
}
