package net.seocoo.ggys.module.merchant.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/19 10:44
 **/
public class H5CMerchantDTO {

  //用户表userInfo的uuid作为环信用户名
  private String userNameEmchant;
  private String name;
  private List<String> merchantLabel;
  private String logoUrl;
  private String secondName;
  private String minPrice;
  private Double distance;
  private String distanceStr;
  private Integer id;

  public String getUserNameEmchant() {
    return userNameEmchant;
  }

  public void setUserNameEmchant(String userNameEmchant) {
    this.userNameEmchant = userNameEmchant;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getMerchantLabel() {
    return merchantLabel;
  }

  public void setMerchantLabel(List<String> merchantLabel) {
    this.merchantLabel = merchantLabel;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public String getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(String minPrice) {
    this.minPrice = minPrice;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public String getDistanceStr() {
    if(distance<1000){
      distanceStr = distance+"m";
    }else {
      distanceStr =String.format("%.1f", distance/1000.0) + "km";
    }
    return distanceStr;
  }

  public void setDistanceStr(String distanceStr) {
    this.distanceStr = distanceStr;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
