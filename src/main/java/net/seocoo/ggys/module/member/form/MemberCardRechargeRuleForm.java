package net.seocoo.ggys.module.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * 会员卡充值规则表单
 * @author PanChengHao
 * @date 2018/6/7 18:20
 */
@ApiModel(value = "会员卡充值规则表单")
public class MemberCardRechargeRuleForm {

  private Integer id;

  @ApiModelProperty(value = "充值金额")
  @NotNull(message = "充值金额不能为空")
  private BigDecimal rechargeMoney;

  @ApiModelProperty(value = "赠送金额")
  private BigDecimal giftMoney;

  @ApiModelProperty(value = "排序码")
  private Integer sortNumber;

  @ApiModelProperty(value = "商家id")
  private Integer merchantId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getRechargeMoney() {
    return rechargeMoney;
  }

  public void setRechargeMoney(BigDecimal rechargeMoney) {
    this.rechargeMoney = rechargeMoney;
  }

  public BigDecimal getGiftMoney() {
    return giftMoney;
  }

  public void setGiftMoney(BigDecimal giftMoney) {
    this.giftMoney = giftMoney;
  }

  public Integer getSortNumber() {
    return sortNumber;
  }

  public void setSortNumber(Integer sortNumber) {
    this.sortNumber = sortNumber;
  }

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }
}
