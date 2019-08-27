package net.seocoo.ggys.module.merchant.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.module.merchant.constans.MerchantFunctionEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/5 0005 16:24
 * @Email xieheng91@163.com
 * @Desc 商户信息表单
 */
@ApiModel(value = "商户返回前端传输对象", description = "用于前端列表的商户信息展示")
public class MerchantDTO implements Serializable {

    private Integer id;


    private String uuid;
    /**
     * 商户名
     */
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
    @ApiModelProperty(value = "商圈Id")
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


    private Integer merchantUserId;

    /**
     * 商户社长名
     */
    private String manageUserName;

    /**
     * 账号
     */
    @ApiModelProperty(value = "商户登录名")
    private String loginName;

    /**
     * 分类id集合
     */
    @ApiModelProperty(value = "行业二级分类Id集合")
    private List<Integer> classifyIdList;

    @ApiModelProperty(value = "行业二级分类名称集合")
    private List<String> classifyNameList;

    @ApiModelProperty(value = "商户功能模块名称集合")
    private List<MerchantFunctionEnum> merchantFunctionModelList;

    /**
     * 商户标签集合
     */
    private List<String> labelList;

    /**
     * 联系电话
     */
    private String linkPhone;
    /**
     * 联系人
     */
    private String linkName;

    private String minPrice;

    private Double distance;

    private String distanceStr;


    public String getDistanceStr() {
        if (distance != null) {
            if (distance < 1000) {
                distanceStr = distance + "m";
            } else {
                distanceStr = String.format("%.1f", distance / 1000.0) + "km";
            }
            return distanceStr;
        }
        return distanceStr;
    }

    public void setDistanceStr(String distanceStr) {
        this.distanceStr = distanceStr;
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

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    public String getUuid() {
        return uuid;
    }

    public Integer getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Integer merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public List<String> getClassifyNameList() {
        return classifyNameList;
    }

    public void setClassifyNameList(List<String> classifyNameList) {
        this.classifyNameList = classifyNameList;
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

    public String getManageUserName() {
        return manageUserName;
    }

    public void setManageUserName(String manageUserName) {
        this.manageUserName = manageUserName;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
