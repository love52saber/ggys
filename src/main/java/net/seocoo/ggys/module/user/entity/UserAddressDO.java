package net.seocoo.ggys.module.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.SexEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;

import java.io.Serializable;
import java.util.Date;
@ApiModel(value = "用户收货地址表")
public class UserAddressDO implements Serializable {

  private Integer id;

  private String uuid;

  @JSONField(serialize = false)
  private Integer userId;

  @ApiModelProperty(value = "收货人姓名")
  private String fullName;

  @ApiModelProperty(value = "收货人联系电话")
  private String phone;

  @ApiModelProperty(value = "省")
  private String province;

  @ApiModelProperty(value = "市")
  private String city;

  @ApiModelProperty(value = "区县")
  private String county;

  @ApiModelProperty(value = "详细地址")
  private String address;

  @ApiModelProperty(value = "性别")
  private SexEnum sex;

  @ApiModelProperty(value = "是否是默认地址")
  private YesNoEnum canDefaultAddress;

  @ApiModelProperty(value = "邮编")
  private String postalCode;

  private Date createDate;

  private Date updateDate;

  @JSONField(serialize = false)
  private YesNoEnum canDeleted;

  private static final long serialVersionUID = 1L;

  public UserAddressDO(Integer id, String uuid, Integer userId, String fullName, String phone, String province, String city, String county, String address, SexEnum sex, YesNoEnum canDefaultAddress, String postalCode, Date createDate, Date updateDate, YesNoEnum canDeleted) {
    this.id = id;
    this.uuid = uuid;
    this.userId = userId;
    this.fullName = fullName;
    this.phone = phone;
    this.province = province;
    this.city = city;
    this.county = county;
    this.address = address;
    this.sex = sex;
    this.canDefaultAddress = canDefaultAddress;
    this.postalCode = postalCode;
    this.createDate = createDate;
    this.updateDate = updateDate;
    this.canDeleted = canDeleted;
  }

  public UserAddressDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  /**
   * get用户id
   * @return
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * set用户id
   * @param userId
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * get收货人姓名
   * @return
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * set收货人姓名
   * @param fullName
   */
  public void setFullName(String fullName) {
    this.fullName = fullName == null ? null : fullName.trim();
  }

  /**
   * get收货人电话
   * @return
   */
  public String getPhone() {
    return phone;
  }

  /**
   * set收货人电话
   * @param phone
   */
  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  /**
   * get收货人省
   * @return
   */
  public String getProvince() {
    return province;
  }

  /**
   * set收货人省
   * @param province
   */
  public void setProvince(String province) {
    this.province = province == null ? null : province.trim();
  }

  /**
   * get收货人市
   * @return
   */
  public String getCity() {
    return city;
  }

  /**
   * set收货人市
   * @param city
   */
  public void setCity(String city) {
    this.city = city == null ? null : city.trim();
  }

  /**
   * get收货人区县
   * @return
   */
  public String getCounty() {
    return county;
  }

  /**
   * set收货人区县
   * @param county
   */
  public void setCounty(String county) {
    this.county = county == null ? null : county.trim();
  }

  /**
   * get收货人详细地址
   * @return
   */
  public String getAddress() {
    return address;
  }

  /**
   * set收货人详细地址
   * @param address
   */
  public void setAddress(String address) {
    this.address = address == null ? null : address.trim();
  }

  /**
   * 收货人性别
   * @return
   */
  public SexEnum getSex() {
    return sex;
  }
  /**
   * 收货人性别
   * @return
   */
  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public YesNoEnum getCanDefaultAddress() {
    return canDefaultAddress;
  }

  public void setCanDefaultAddress(YesNoEnum canDefaultAddress) {
    this.canDefaultAddress = canDefaultAddress;
  }

  /**
   * get邮编
   */
  public String getPostalCode() {
    return postalCode;
  }

  /**
   * set邮编
   * @param postalCode
   */
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode == null ? null : postalCode.trim();
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public YesNoEnum getCanDeleted() {
    return canDeleted;
  }

  public void setCanDeleted(YesNoEnum canDeleted) {
    this.canDeleted = canDeleted;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    UserAddressDO other = (UserAddressDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
        && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
        && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
        && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
        && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
        && (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty()))
        && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
        && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
        && (this.getCanDefaultAddress() == null ? other.getCanDefaultAddress() == null : this.getCanDefaultAddress().equals(other.getCanDefaultAddress()))
        && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
    result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
    result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
    result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
    result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
    result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
    result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
    result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
    result = prime * result + ((getCanDefaultAddress() == null) ? 0 : getCanDefaultAddress().hashCode());
    result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "UserAddressDO{" +
        "id=" + id +
        ", uuid='" + uuid + '\'' +
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
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", canDeleted='" + canDeleted + '\'' +
        '}';
  }
}