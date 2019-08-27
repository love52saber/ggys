package net.seocoo.ggys.module.member.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PanChengHao
 * @date 2018/6/15 9:26
 */
public class MemberMerchantListDTO {

  private Integer merchantId;

  //商家logo
  private String logoUrl;

  //商家名称
  private String merchantName;

  //距离
  private Double distance;

  //会员卡编号
  private String memberCardNo;

  //会员卡余额
  private BigDecimal remainingMoney;

  //商家标签
  private List<String> merchantLabel;

  private String distanceStr;

  public Integer getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Integer merchantId) {
    this.merchantId = merchantId;
  }


  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
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

  public List<String> getMerchantLabel() {
    return merchantLabel;
  }

  public void setMerchantLabel(List<String> merchantLabel) {
    this.merchantLabel = merchantLabel;
  }

  public String getDistanceStr() {
    if(distance !=null && distance<1000){
      distanceStr = distance+"m";
    }else if(distance !=null && distance >= 1000){
      distanceStr =String.format("%.1f", distance/1000.0) + "km";
    }
    return distanceStr;
  }

  public void setDistanceStr(String distanceStr) {
    this.distanceStr = distanceStr;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
