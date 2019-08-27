package net.seocoo.ggys.module.order.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.order.constants.OrderPayTypeEnum;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 团购订单
 * @author xieheng
 */
@ApiModel("团购订单")
public class GrouponOrderDTO {

  private Integer id;//主键

  private Integer grouponOrderId;//团购订单逐渐

  private Short count;//数量

  private String orderNo;//订单号

  private Date orderDate;//下单日期

  private BigDecimal orderFee;//订单费用

  private BigDecimal orderActualFee;//订单实际费用

  private OrderPayTypeEnum payType;//支付类型

  private String payTypeDesc;//支付类型说明

  private BigDecimal orderPayActualFee;//订单实际支付费用

  private BigDecimal orderCouponFee;//优惠卷费用

  private String goodsName;//商品名

  private String nickName;//下单人名

  private Date bookStartDate;//预约开始时间

  private Date bookEndDate;//预约结束时间

  private OrderStateEnum orderState;//订单状态

  private String orderStateDesc;//订单状态说明

  private String merchantName;

  private String merchantLogoUrl;

  private String goodsImgUrl;


  private OrderTypeEnum orderType;

  private String orderTypeDesc;

  public OrderTypeEnum getOrderType() {
    return orderType;
  }

  public void setOrderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
  }

  public String getOrderTypeDesc() {
    return orderTypeDesc;
  }

  public void setOrderTypeDesc(String orderTypeDesc) {
    this.orderTypeDesc = orderTypeDesc;
  }

  public String getGoodsImgUrl() {
    return goodsImgUrl;
  }

  public void setGoodsImgUrl(String goodsImgUrl) {
    this.goodsImgUrl = goodsImgUrl;
  }

  public String getMerchantLogoUrl() {
    return merchantLogoUrl;
  }

  public void setMerchantLogoUrl(String merchantLogoUrl) {
    this.merchantLogoUrl = merchantLogoUrl;
  }

  /**
   * 团购商品价格
   */
  private BigDecimal goodsPrice;

  public BigDecimal getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(BigDecimal goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public OrderStateEnum getOrderState() {
    return orderState;
  }

  public void setOrderState(OrderStateEnum orderState) {
    this.orderState = orderState;
  }

  public String getOrderStateDesc() {
    return orderStateDesc;
  }

  public void setOrderStateDesc(String orderStateDesc) {
    this.orderStateDesc = orderStateDesc;
  }

  public String getPayTypeDesc() {
    return payTypeDesc;
  }

  public void setPayTypeDesc(String payTypeDesc) {
    this.payTypeDesc = payTypeDesc;
  }

  public Date getBookStartDate() {
    return bookStartDate;
  }

  public void setBookStartDate(Date bookStartDate) {
    this.bookStartDate = bookStartDate;
  }

  public Date getBookEndDate() {
    return bookEndDate;
  }

  public void setBookEndDate(Date bookEndDate) {
    this.bookEndDate = bookEndDate;
  }

  public Short getCount() {
    return count;
  }

  public void setCount(Short count) {
    this.count = count;
  }

  public Integer getGrouponOrderId() {
    return grouponOrderId;
  }

  public void setGrouponOrderId(Integer grouponOrderId) {
    this.grouponOrderId = grouponOrderId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  private static final long serialVersionUID = 1L;


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



  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
