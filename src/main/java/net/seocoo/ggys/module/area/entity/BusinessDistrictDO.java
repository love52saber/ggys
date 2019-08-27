package net.seocoo.ggys.module.area.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class BusinessDistrictDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    //省份名称
    private String provinceName;

    //城市名称
    private String cityName;

    //区县名称
    private String countyName;

    //商圈名称
    private String name;

    //商圈详细地址
    private String address;

    //省份编码
    private String provinceCode;

    //城市编码
    private String cityCode;

    //区县编码
    private String countyCode;

    //是否删除
    @JSONField(serialize = false)

    private YesNoEnum canDeleted;

    //创建人
    private Integer createUserId;

    //更新人
    private Integer updateUserId;

    //创建时间
    private Date createDate;

    //更新时间
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public BusinessDistrictDO(Integer id, String uuid, String provinceName, String cityName, String countyName, String name, String address, String provinceCode, String cityCode, String countyCode, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.countyName = countyName;
        this.name = name;
        this.address = address;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
        this.canDeleted = canDeleted;
    }

    public BusinessDistrictDO() {
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
     * get省份名称
     * @return 省份名称
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * set省份名称
     * @param provinceName
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * get城市名称
     * @return 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * set城市名称
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * get区县名称
     * @return 区县名称
     */
    public String getCountyName() {
        return countyName;
    }

    /**
     * set区县名称
     * @param countyName
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName == null ? null : countyName.trim();
    }

    /**
     * get商圈名称
     * @return 商圈名称
     */
    public String getName() {
        return name;
    }

    /**
     * set商圈名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get
     * @return 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * set详细地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * get省份编码
     * @return 省份编码
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * set省份编码
     * @param provinceCode
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    /**
     * get城市编码
     * @return 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * set城市编码
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * get区县编码
     * @return 区县编码
     */
    public String getCountyCode() {
        return countyCode;
    }

    /**
     * set区县编码
     * @param countyCode
     */
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode == null ? null : countyCode.trim();
    }

    /**
     * get是否删除
     * @return 是否删除
     */
    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    /**
     * set状态
     * @param canDeleted
     */
    public void setCanDeleted(YesNoEnum canDeleted) {
        this.canDeleted = canDeleted == null ? null : canDeleted;
    }

    /**
     * get创建人
     * @return 创建人
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * set创建人
     * @param createUserId
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * get更新人
     * @return 更新人
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * set更新人
     * @param updateUserId
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * get创建时间
     * @return 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * set创建时间
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * get更新时间
     * @return 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * set更新时间
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        BusinessDistrictDO other = (BusinessDistrictDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getProvinceName() == null ? other.getProvinceName() == null : this.getProvinceName().equals(other.getProvinceName()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getCountyName() == null ? other.getCountyName() == null : this.getCountyName().equals(other.getCountyName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getCountyCode() == null ? other.getCountyCode() == null : this.getCountyCode().equals(other.getCountyCode()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getCountyName() == null) ? 0 : getCountyName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getCountyCode() == null) ? 0 : getCountyCode().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}