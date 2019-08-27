package net.seocoo.ggys.module.order.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/7 16:09
 **/
@Api(value = "团购订单下单")
public class GrouponOrderForm {

  @ApiModelProperty(value = "订单基类表主键")
  private Integer merchantBaseOrderId;

  @ApiModelProperty(value = "订单数量")
  private Integer orderCount;

  @ApiModelProperty(value = "是否使用会员卡")
  private YesNoEnum useMemberCard;

  @ApiModelProperty(value = "团购商品Id")
  private Integer goodsId;

  @ApiModelProperty(value = "优惠券Id")
  private Integer couponId;

  @ApiModelProperty(value = "商家Id")
  private Integer merchantId;

  @ApiModelProperty(value = "订单状态")
  private OrderStateEnum orderState;

  public OrderStateEnum getOrderState() {
    return orderState;
  }

  public void setOrderState(OrderStateEnum orderState) {
    this.orderState = orderState;
  }

  public Integer getMerchantBaseOrderId() {
    return merchantBaseOrderId;
  }

  public void setMerchantBaseOrderId(Integer merchantBaseOrderId) {
    this.merchantBaseOrderId = merchantBaseOrderId;
  }

  public Integer getOrderCount() {
    return orderCount;
  }

  public void setOrderCount(Integer orderCount) {
    this.orderCount = orderCount;
  }

  public YesNoEnum getUseMemberCard() {
    return useMemberCard;
  }

  public void setUseMemberCard(YesNoEnum useMemberCard) {
    this.useMemberCard = useMemberCard;
  }

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }

  public Integer getCouponId() {
    return couponId;
  }

  public void setCouponId(Integer couponId) {
    this.couponId = couponId;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }
}
