package net.seocoo.ggys.module.user.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.SexEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;

/**
 * @author wangpan
 * @date 2018/6/7 15:54
 */
@ApiModel("用户收货地址表单 ")
public class UserAddressForm {
  @ApiModelProperty("主键")
  private Integer id;

  @ApiModelProperty("用户的id")
  private Integer userId;

  @ApiModelProperty("收货人姓名")
  private String fullName;

  @ApiModelProperty("收货人手机号")
  private String phone;

  @ApiModelProperty("省份")
  private String province;

  @ApiModelProperty("城市")
  private String city;

  @ApiModelProperty("区县")
  private String county;

  @ApiModelProperty("详细收货地址")
  private String address;

  @ApiModelProperty("性别")
  private SexEnum sex;

  @ApiModelProperty("是否是默认地址")
  private YesNoEnum canDefaultAddress;

  @ApiModelProperty("邮政编码")
  private String postalCode;

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

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) { this.sex = sex; }

  public YesNoEnum getCanDefaultAddress() {
    return canDefaultAddress;
  }

  public void setCanDefaultAddress(YesNoEnum canDefaultAddress) {
    this.canDefaultAddress = canDefaultAddress;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "UserAddressForm{" +
        "id=" + id +
        ", userId=" + userId +
        ", fullName='" + fullName + '\'' +
        ", phone='" + phone + '\'' +
        ", province='" + province + '\'' +
        ", city='" + city + '\'' +
        ", county='" + county + '\'' +
        ", address='" + address + '\'' +
        ", sex='" + sex + '\'' +
        ", canDefaultAddress='" + canDefaultAddress + '\'' +
        ", postalCode='" + postalCode + '\'' +
        '}';
  }
}
