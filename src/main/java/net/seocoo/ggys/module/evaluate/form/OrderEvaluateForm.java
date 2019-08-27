package net.seocoo.ggys.module.evaluate.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.module.evaluate.constants.OrderEvaluateResultEnum;

/**
 * @author PanChengHao
 * @date 2018/6/13 17:39
 */
@ApiModel(value = "订单评价表单类")
public class OrderEvaluateForm {

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "用户id")
  private Integer userId;

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "订单id")
  private Integer orderId;

  @ApiModelProperty(value = "评价结果")
  private OrderEvaluateResultEnum evaluateResult;

  @ApiModelProperty(value = "评价具体内容")
  private String content;

  private static final long serialVersionUID = 1L;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

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
}
