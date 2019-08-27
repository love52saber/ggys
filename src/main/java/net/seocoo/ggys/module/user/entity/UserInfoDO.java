package net.seocoo.ggys.module.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.UserRoleEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
@ApiModel("用户信息表 ")
public class UserInfoDO implements Serializable {
  private Integer id;
  @JSONField(serialize=false)
  private String token;
//  @JSONField(serialize=false)
  private String uuid;
  /**
   * 用户昵称
   */
  @ApiModelProperty(value = "昵称")
  private String nickname;
  /**
   * 用户姓名
   */
  @ApiModelProperty(value = "用户姓名")
  private String fullName;
  /**
   * 手机号
   */
  @ApiModelProperty(value = "手机号")
  private String phone;
  /**
   * 微信openId
   */
  @ApiModelProperty(value = "微信openId")
  private String openId;
  /**
   * 登陆名称
   */
  @ApiModelProperty(value = "登陆名称")
  private String loginName;
  @JSONField(serialize=false)
  private String password;
  /**
   * 头像
   */
  @ApiModelProperty(value = "头像")
  private String headImageUrl;

  private Date createDate;

  private Date updateDate;
  @JSONField(serialize=false)
  private YesNoEnum canDeleted;
  /**
   * 用户角色
   */
  private UserRoleEnum userRole;

  /**
   * 维度
   */
  private Double lat;

  /**
   * 经度
   */
  private Double lng;

  /**
   * 城市ID
   */
  private Integer cityId;
  /**
   * 区县ID
   */
  private Integer districtId;


  private static final long serialVersionUID = 1L;

  public UserInfoDO(Integer id, String token, String uuid, String nickname, String fullName, String phone, String openId, String loginName, String password, String headImageUrl, Date createDate, Date updateDate, YesNoEnum canDeleted, UserRoleEnum userRole) {
    this.id = id;
    this.token = token;
    this.uuid = uuid;
    this.nickname = nickname;
    this.fullName = fullName;
    this.phone = phone;
    this.openId = openId;
    this.loginName = loginName;
    this.password = password;
    this.headImageUrl = headImageUrl;
    this.createDate = createDate;
    this.updateDate = updateDate;
    this.canDeleted = canDeleted;
    this.userRole = userRole;
  }

  public UserInfoDO() {
    super();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public Integer getDistrictId() {
    return districtId;
  }

  public void setDistrictId(Integer districtId) {
    this.districtId = districtId;
  }

  /**
   * 维度
   * @return
   */
  public Double getLat() {
    return lat;
  }

  /**
   * 维度
   * @param lat
   */
  public void setLat(Double lat) {
    this.lat = lat;
  }

  /**
   * 经度
   * @return
   */
  public Double getLng() {
    return lng;
  }

  /**
   * 经度
   * @param lng
   */
  public void setLng(Double lng) {
    this.lng = lng;
  }

  /**
   * get登陆令牌
   *
   * @return
   */
  public String getToken() {
    return token;
  }

  /**
   * 设置登陆令牌
   *
   * @param token
   */
  public void setToken(String token) {
    this.token = token == null ? null : token.trim();
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid == null ? null : uuid.trim();
  }

  /**
   * get微信昵称
   *
   * @return
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * set微信昵称
   *
   * @param nickname
   */
  public void setNickname(String nickname) {
    this.nickname = nickname == null ? null : nickname.trim();
  }

  /**
   * get真实姓名
   *
   * @return
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * set真实姓名
   */
  public void setFullName(String fullName) {
    this.fullName = fullName == null ? null : fullName.trim();
  }

  /**
   * get手机号
   *
   * @return
   */
  public String getPhone() {
    return phone;
  }

  /**
   * set手机号
   *
   * @param phone
   */
  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  /**
   * get微信的openId
   *
   * @return
   */
  public String getOpenId() {
    return openId;
  }

  /**
   * set微信的openId
   *
   * @param openId
   */
  public void setOpenId(String openId) {
    this.openId = openId == null ? null : openId.trim();
  }

  /**
   * get登陆名称
   *
   * @return
   */
  public String getLoginName() {
    return loginName;
  }

  /**
   * set登陆名称
   *
   * @param loginName
   */
  public void setLoginName(String loginName) {
    this.loginName = loginName == null ? null : loginName.trim();
  }

  /**
   * get登陆密码
   *
   * @return
   */
  public String getPassword() {
    return password;
  }

  /**
   * set登陆密码
   *
   * @param password
   */
  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  /**
   * get用户微信头像
   *
   * @return
   */
  public String getHeadImageUrl() {
    return headImageUrl;
  }

  /**
   * set微信用户头像
   *
   * @param headImageUrl
   */
  public void setHeadImageUrl(String headImageUrl) {
    this.headImageUrl = headImageUrl == null ? null : headImageUrl.trim();
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

  /**
   * get用户角色
   *
   * @return
   */
  public UserRoleEnum getUserRole() {
    return userRole;
  }

  /**
   * set用户角色
   *
   * @param userRole
   */
  public void setUserRole(UserRoleEnum userRole) {
    this.userRole = userRole;
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
    net.seocoo.ggys.module.user.entity.UserInfoDO other = (net.seocoo.ggys.module.user.entity.UserInfoDO) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
        && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
        && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
        && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
        && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
        && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
        && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
        && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
        && (this.getHeadImageUrl() == null ? other.getHeadImageUrl() == null : this.getHeadImageUrl().equals(other.getHeadImageUrl()))
        && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()))
        && (this.getUserRole() == null ? other.getUserRole() == null : this.getUserRole().equals(other.getUserRole()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
    result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
    result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
    result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
    result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
    result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
    result = prime * result + ((getHeadImageUrl() == null) ? 0 : getHeadImageUrl().hashCode());
    result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
    result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
    result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
    result = prime * result + ((getUserRole() == null) ? 0 : getUserRole().hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "UserInfoDO{" +
        "id=" + id +
        ", token='" + token + '\'' +
        ", uuid='" + uuid + '\'' +
        ", nickname='" + nickname + '\'' +
        ", fullName='" + fullName + '\'' +
        ", phone='" + phone + '\'' +
        ", openId='" + openId + '\'' +
        ", loginName='" + loginName + '\'' +
        ", password='" + password + '\'' +
        ", headImageUrl='" + headImageUrl + '\'' +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", canDeleted=" + canDeleted +
        ", userRole=" + userRole +
        '}';
  }
}
