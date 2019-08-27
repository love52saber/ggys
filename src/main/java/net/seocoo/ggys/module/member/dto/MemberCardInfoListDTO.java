package net.seocoo.ggys.module.member.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * 会员卡信息集合DTO
 * @author PanChengHao
 * @date 2018/6/11 19:38
 */
public class MemberCardInfoListDTO {
  private String nickname;

  private String fullName;

  private String memberCardNo;

  private BigDecimal remainingMoney;

  private BigDecimal rechargeTotalMoney;

  //商家名称
  private String merchantName;

  //商家logo
  private String logoUrl;

  //商家id
  private Integer merchantId;

  private static final long serialVersionUID = 1L;

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getMemberCardNo() {
    return memberCardNo;
  }

  public void setMemberCardNo(String memberCardNo) {
    this.memberCardNo = memberCardNo;
  }

  public BigDecimal getRemainingMoney() {
    return remainingMoney;
  }

  public void setRemainingMoney(BigDecimal remainingMoney) {
    this.remainingMoney = remainingMoney;
  }

  public BigDecimal getRechargeTotalMoney() {
    return rechargeTotalMoney;
  }

  public void setRechargeTotalMoney(BigDecimal rechargeTotalMoney) {
    this.rechargeTotalMoney = rechargeTotalMoney;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
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
