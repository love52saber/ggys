package net.seocoo.ggys.module.evaluate.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.evaluate.constants.OrderEvaluateResultEnum;
import net.seocoo.ggys.module.goods.constans.GoodsTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author PanChengHao
 * @date 2018/6/14 8:39
 */
@ApiModel(value = "订单评价查询")
public class OrderEvaluateQuery extends BaseQuery {

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "订单id")
  private Integer orderId;

  @ApiModelProperty(value = "订单编号")
  private String orderNo;

  @ApiModelProperty(value = "订单类型")
  private GoodsTypeEnum orderType;

  @ApiModelProperty(value = "订单评价结果")
  private OrderEvaluateResultEnum evaluateResult;

  @ApiModelProperty(value = "用户id")
  private Integer userId;

  private static final long serialVersionUID = 1L;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
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

  public GoodsTypeEnum getOrderType() {
    return orderType;
  }

  public void setOrderType(GoodsTypeEnum orderType) {
    this.orderType = orderType;
  }

  public OrderEvaluateResultEnum getEvaluateResult() {
    return evaluateResult;
  }

  public void setEvaluateResult(OrderEvaluateResultEnum evaluateResult) {
    this.evaluateResult = evaluateResult;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
