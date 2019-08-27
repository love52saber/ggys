package net.seocoo.ggys.module.merchant.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:hengxie
 * @date:2018/6/5 0005
 * @description: 商户实体
 */
public class MerchantDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    /**
     * 简称
     */
    private String simpleName;

    /**
     * 商户名
     */
    private String name;

    /**
     * 连锁编码
     */
    private Integer merchantNo;

    /**
     * 省id
     */
    private String provinceId;

    /**
     * 城市id
     */
    private String cityId;

    /**
     * 区,县级id
     */
    private String countyId;

    /**
     * 商圈id
     */
    private String businessAreaId;
    /**
     * 省名
     */
    private String provinceName;

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 区县名
     */
    private String countyName;


    /**
     * 商圈名
     */
    private String businessAreaName;
    /**
     * 地址
     */
    private String address;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lon;

    /**
     * 联系电话
     */
    private String linkPhone;
    /**
     * 联系人
     */
    private String linkName;

    /**
     * logo图片的url
     */
    private String logoUrl;

    /**
     * 商户开放业务
     */
    private String merchantFunction;
    /**
     * 商户userId
     */
    private Integer merchantUserId;

    /**
     * 社长userId
     */
    private Integer manageUserId;

    /**
     * 商户号
     */
    private String shopNo;

    @JSONField(serialize = false)
    private Date createDate;

    @JSONField(serialize = false)
    private Integer createUserId;

    @JSONField(serialize = false)
    private Date updateDate;

    @JSONField(serialize = false)
    private Integer updateUserId;

    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;


    public MerchantDO() {
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

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName == null ? null : simpleName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Integer merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getMerchantFunction() {
        return merchantFunction;
    }

    public void setMerchantFunction(String merchantFunction) {
        this.merchantFunction = merchantFunction;
    }

    public Integer getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Integer merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Integer getManageUserId() {
        return manageUserId;
    }

    public void setManageUserId(Integer manageUserId) {
        this.manageUserId = manageUserId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    public void setCanDeleted(YesNoEnum canDeleted) {
        this.canDeleted = canDeleted;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}