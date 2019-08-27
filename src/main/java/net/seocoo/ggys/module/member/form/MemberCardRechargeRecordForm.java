package net.seocoo.ggys.module.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.PayTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 会员卡充值记录表单类
 * @author PanChengHao
 * @date 2018/6/7 20:05
 */
@ApiModel(value = "会员卡充值记录表单")
public class MemberCardRechargeRecordForm {

  @ApiModelProperty(value = "会员卡id")
  private Integer memberCardId;

  @ApiModelProperty(value = "会员卡充值规则id")
  private Integer rechargeRuleId;

  @ApiModelProperty(value = "商家id")
  private Integer merchantId;

  @ApiModelProperty(value = "支付类型")
  private PayTypeEnum payType;

  @ApiModelProperty(value = "用户id")
  private Integer userId;

  public Integer getRechargeRuleId() {
    return rechargeRuleId;
  }

  public void setRechargeRuleId(Integer rechargeRuleId) {
    this.rechargeRuleId = rechargeRuleId;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  public PayTypeEnum getPayType() {
    return payType;
  }

  public void setPayType(PayTypeEnum payType) {
    this.payType = payType;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getMemberCardId() {
    return memberCardId;
  }

  public void setMemberCardId(Integer memberCardId) {
    this.memberCardId = memberCardId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
