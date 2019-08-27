package net.seocoo.ggys.module.member.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.PayTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author PanChengHao
 * @date 2018/6/1 11:59
 */
@ApiModel(value = "会员卡充值记录查询")
public class MemberCardRechargeRecordQuery extends BaseQuery {

  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "支付类型")
  private PayTypeEnum payType;

  @ApiModelProperty(value = "用户id")
  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public PayTypeEnum getPayType() {
    return payType;
  }

  public void setPayType(PayTypeEnum payType) {
    this.payType = payType;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
