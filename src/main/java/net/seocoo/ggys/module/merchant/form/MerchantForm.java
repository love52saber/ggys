package net.seocoo.ggys.module.merchant.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.module.merchant.constans.MerchantFunctionEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/5 0005 16:24
 * @Email xieheng91@163.com
 * @Desc 商户信息表单
 */
@ApiModel(value = "商户表单",description = "用于表单的增加与编辑操作")
public class MerchantForm implements Serializable {

  private Integer id;

  /**
   * 联系电话
   */
  @ApiModelProperty(value = "联系电话")
  private String linkPhone;

  /**
   * 商户名
   */
  @NotBlank(message = "商户名称不能为空")
  @ApiModelProperty(value = "商户名称")
  private String name;

  /**
   * 连锁编码
   */
  @ApiModelProperty(value = "连锁编码")
  private Integer merchantNo;

  /**
   * 省id
   */
  @ApiModelProperty(value = "省份Id")
  private String provinceId;

  /**
   * 城市id
   */
  @ApiModelProperty(value = "城市Id")
  private String cityId;

  /**
   * 区,县级id
   */
  @ApiModelProperty(value = "区县Id")
  private String countyId;

  /**
   * 商圈id
   */
  @ApiModelProperty(value="商圈Id")
  private String businessAreaId;


  /**
   * 省名
   */
  @ApiModelProperty(value = "省名")
  private String provinceName;

  /**
   * 城市名
   */
  @ApiModelProperty(value = "城市名")
  private String cityName;

  /**
   * 区县名
   */
  @ApiModelProperty(value = "区县名")
  private String countyName;


  /**
   * 商圈名
   */
  @ApiModelProperty(value = "商圈名")
  private String businessAreaName;
  /**
   * 地址
   */
  @NotBlank(message = "商户地址不能为空")
  @ApiModelProperty(value = "商户地址")
  private String address;

  /**
   * logo图片的url
   */
  @ApiModelProperty(value = "商户logo图片")
  private String logoUrl;

  /**
   * 社长userId
   */
  @ApiModelProperty(value = "商户社长Id")
  private Integer manageUserId;

  /**
   * 账号
   */
  @ApiModelProperty(value = "商户登录名")
  private String loginName;

  /**
   * 密码
   */
@ApiModelProperty(value = "密码")
  private String password;

  /**
   * 确认密码
   */
  @ApiModelProperty(value = "确认密码")
  private String confirmPassword;

  /**
   * 分类id集合
   */
  @ApiModelProperty(value = "行业二级分类Id集合")
  private List<Integer> classifyIdList;

  @ApiModelProperty(value = "商户功能模块名称集合")
  private List<MerchantFunctionEnum> merchantFunctionModelList;

  public String getLinkPhone() {
    return linkPhone;
  }

  public void setLinkPhone(String linkPhone) {
    this.linkPhone = linkPhone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMerchantNo() {
    return merchantNo;
  }

  public void setMerchantNo(Integer merchantNo) {
    this.merchantNo = merchantNo;
  }

  public String getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(String provinceId) {
    this.provinceId = provinceId;
  }

  public String getCityId() {
    return cityId;
  }

  public void setCityId(String cityId) {
    this.cityId = cityId;
  }

  public String getCountyId() {
    return countyId;
  }

  public void setCountyId(String countyId) {
    this.countyId = countyId;
  }

  public String getBusinessAreaId() {
    return businessAreaId;
  }

  public void setBusinessAreaId(String businessAreaId) {
    this.businessAreaId = businessAreaId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public Integer getManageUserId() {
    return manageUserId;
  }

  public void setManageUserId(Integer manageUserId) {
    this.manageUserId = manageUserId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public List<Integer> getClassifyIdList() {
    return classifyIdList;
  }

  public void setClassifyIdList(List<Integer> classifyIdList) {
    this.classifyIdList = classifyIdList;
  }

  public List<MerchantFunctionEnum> getMerchantFunctionModelList() {
    return merchantFunctionModelList;
  }

  public void setMerchantFunctionModelList(List<MerchantFunctionEnum> merchantFunctionModelList) {
    this.merchantFunctionModelList = merchantFunctionModelList;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName;
  }

  public String getBusinessAreaName() {
    return businessAreaName;
  }

  public void setBusinessAreaName(String businessAreaName) {
    this.businessAreaName = businessAreaName;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
