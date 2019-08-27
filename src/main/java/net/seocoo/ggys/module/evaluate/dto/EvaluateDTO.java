package net.seocoo.ggys.module.evaluate.dto;

import net.seocoo.ggys.module.evaluate.constants.OrderEvaluateResultEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;

/**
 * @author PanChengHao
 * @date 2018/6/20 11:33
 */
public class EvaluateDTO {

  //昵称
  private String nickname;

  //评价结果
  private OrderEvaluateResultEnum evaluateResult;

  //订单类型
  private OrderTypeEnum orderType;

  //评价id
  private Integer id;

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public OrderEvaluateResultEnum getEvaluateResult() {
    return evaluateResult;
  }

  public void setEvaluateResult(OrderEvaluateResultEnum evaluateResult) {
    this.evaluateResult = evaluateResult;
  }

  public OrderTypeEnum getOrderType() {
    return orderType;
  }

  public void setOrderType(OrderTypeEnum orderType) {
    this.orderType = orderType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
