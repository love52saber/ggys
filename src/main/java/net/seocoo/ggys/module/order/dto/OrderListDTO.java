package net.seocoo.ggys.module.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;

import java.util.Date;

/**
 * 订单列表DTO
 * @author ZengXiaoLiang
 * @date 2018/6/8 15:23
 **/
@ApiModel("订单列表")
public class OrderListDTO {
  private Integer orderId;

  @ApiModelProperty("订单编号")
  private String orderNo;

  @ApiModelProperty(value = "用户头像url")
  private String userHeadImageUrl;

  @ApiModelProperty(value = "昵称")
  private String nickName;

  @ApiModelProperty(value = "商品名")
  private String goodsName;

  /**
   * 商品小图
   */
  private String goodsSmallImgUrl;

  @ApiModelProperty(value = "数量")
  private Short count;

  @ApiModelProperty(value = "订单费用")
  private String orderFee;

  @ApiModelProperty(value = "预约开始时间")
  private Date bookStartDate;

  @ApiModelProperty(value = "预约结束时间")
  private Date bookEndDate;

  @ApiModelProperty(value = "订单类型")
  private OrderTypeEnum orderType;

  @ApiModelProperty(value = "订单类型")
  private String orderTypeDesc;


  @ApiModelProperty(value = "是否预约")
  private String isBook;

  @ApiModelProperty(value = "订单状态")
  private OrderStateEnum orderState;

  @ApiModelProperty(value = "订单状态说明")
  private String orderStateDesc;

  private String merchantName;

  public String getGoodsSmallImgUrl() {
    return goodsSmallImgUrl;
  }

  public void setGoodsSmallImgUrl(String goodsSmallImgUrl) {
    this.goodsSmallImgUrl = goodsSmallImgUrl;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getOrderStateDesc() {
    return orderStateDesc;
  }

  public void setOrderStateDesc(String orderStateDesc) {
    this.orderStateDesc = orderStateDesc;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public String getUserHeadImageUrl() {
    return userHeadImageUrl;
  }

  public void setUserHeadImageUrl(String userHeadImageUrl) {
    this.userHeadImageUrl = userHeadImageUrl;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Short getCount() {
    return count;
  }

  public void setCount(Short count) {
    this.count = count;
  }

  public String getOrderFee() {
    return orderFee;
  }

  public void setOrderFee(String orderFee) {
    this.orderFee = orderFee;
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

  public String getIsBook() {
    return isBook;
  }

  public void setIsBook(String isBook) {
    this.isBook = isBook;
  }

  public OrderStateEnum getOrderState() {
    return orderState;
  }

  public void setOrderState(OrderStateEnum orderState) {
    this.orderState = orderState;
  }
}
