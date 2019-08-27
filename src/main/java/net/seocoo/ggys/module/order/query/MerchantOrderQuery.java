package net.seocoo.ggys.module.order.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/8 16:15
 **/
@ApiModel("订单查询Order")
public class MerchantOrderQuery extends BaseQuery {

  private String name;

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "下单人用户id")
  private Integer orderUserId;

  @ApiModelProperty(value = "订单类型,外卖,团购")
  private OrderTypeEnum orderType;

  @ApiModelProperty(value = "订单编号")
  private String orderNo;

  @ApiModelProperty(value = "订单状态")
  private OrderStateEnum orderState;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public OrderStateEnum getOrderState() {
    return orderState;
  }

  public void setOrderState(OrderStateEnum orderState) {
    this.orderState = orderState;
  }

  public OrderTypeEnum getOrderType() {
    return orderType;
  }

  public void setOrderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
  }

  public Integer getOrderUserId() {
    return orderUserId;
  }

  public void setOrderUserId(Integer orderUserId) {
    this.orderUserId = orderUserId;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }
}
