package net.seocoo.ggys.module.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 会员卡消费记录表单
 * @author PanChengHao
 * @date 2018/6/7 21:10
 */
@ApiModel(value = "会员卡消费记录表单")
public class MemberCardConsumeRecordForm {

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "会员卡id")
  private Integer memberCardId;

  @ApiModelProperty(value = "订单id")
  private Integer orderId;

  @ApiModelProperty(value = "消费金额")
  private BigDecimal consumeMoney;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public Integer getMemberCardId() {
    return memberCardId;
  }

  public void setMemberCardId(Integer memberCardId) {
    this.memberCardId = memberCardId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public BigDecimal getConsumeMoney() {
    return consumeMoney;
  }

  public void setConsumeMoney(BigDecimal consumeMoney) {
    this.consumeMoney = consumeMoney;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
