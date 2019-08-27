package net.seocoo.ggys.module.member.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.PayTypeEnum;
import net.seocoo.ggys.core.constants.SexEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author PanChengHao
 * @date 2018/6/1 17:12
 */
@ApiModel(value = "会员卡信息表单")
public class MemberCardForm {

  @ApiModelProperty(value = "用户Id")
  private Integer userId;

  @Length(min = 1, max=20, message = "姓名长度应在1-20个字符以内")
  @ApiModelProperty(value="姓名 浩子")
  private String fullName;

  @NotNull(message = "手机号不能为空")
  @ApiModelProperty(value = "手机号 15156522646")
  private String phone;

  @ApiModelProperty(value="性别 MALE")
  private SexEnum sex;

  @ApiModelProperty(value = "生日 2018-08-08")
  private Date birthday;

  @NotNull(message = "充值金额不能为空")
  @ApiModelProperty(value = "充值规则id 6")
  private Integer rechargeRuleId;

  @ApiModelProperty(value = "支付方式 WX")
  private PayTypeEnum payType;

  @ApiModelProperty(value = "id")
  private Integer memberCardId;

  @NotNull(message = "商户id不能为空")
  @ApiModelProperty(value = "商户id")
  private Integer merchantId;

  @ApiModelProperty(value = "余额")
  private BigDecimal remainingMoney;

  @ApiModelProperty(value = "充值累计金额")
  private BigDecimal rechargeTotalMoney;

  private static final long serialVersionUID = 1L;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getRechargeRuleId() {
    return rechargeRuleId;
  }

  public void setRechargeRuleId(Integer rechargeRuleId) {
    this.rechargeRuleId = rechargeRuleId;
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

  public BigDecimal getRemainingMoney() {
    return remainingMoney;
  }

  public void setRemainingMoney(BigDecimal remainingMoney) {
    this.remainingMoney = remainingMoney;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public BigDecimal getRechargeTotalMoney() {
    return rechargeTotalMoney;
  }

  public void setRechargeTotalMoney(BigDecimal rechargeTotalMoney) {
    this.rechargeTotalMoney = rechargeTotalMoney;
  }

  public Integer getMemberCardId() {
    return memberCardId;
  }

  public void setMemberCardId(Integer memberCardId) {
    this.memberCardId = memberCardId;
  }
}
