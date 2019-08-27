package net.seocoo.ggys.module.area.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.module.area.constants.LevelEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class AreaDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private Integer parentId;

    //城市编码
    private String cityCode;

    //区域编码
    private String areaDistrictCode;

    //名称
    private String name;

    //经纬度
    private String center;

    //行政区域等级，省市区县
    private LevelEnum level;

    private static final long serialVersionUID = 1L;

    public AreaDO(Integer id, Integer parentId, String cityCode, String areaDistrictCode, String name, String center, LevelEnum level) {
        this.id = id;
        this.parentId = parentId;
        this.cityCode = cityCode;
        this.areaDistrictCode = areaDistrictCode;
        this.name = name;
        this.center = center;
        this.level = level;
    }

    public AreaDO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * get区域编码
     * @return 区域编码
     */
    public String getAreaDistrictCode() {
        return areaDistrictCode;
    }

    /**
     * set区域编码
     * @param areaDistrictCode
     */
    public void setAreaDistrictCode(String areaDistrictCode) {
        this.areaDistrictCode = areaDistrictCode == null ? null : areaDistrictCode.trim();
    }

    /**
     * get名称
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * set名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * get经纬度
     * @return
     */
    public String getCenter() {
        return center;
    }

    /**
     * set经纬度
     * @param center
     */
    public void setCenter(String center) {
        this.center = center == null ? null : center.trim();
    }

    /**
     * get行政区域等级，省市区县
     * @return 行政区域等级，省市区县
     */
    public LevelEnum getLevel() {
        return level;
    }

    /**
     * set行政区域等级，省市区县
     * @param level
     */
    public void setLevel(LevelEnum level) {
        this.level = level;
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
        AreaDO other = (AreaDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getAreaDistrictCode() == null ? other.getAreaDistrictCode() == null : this.getAreaDistrictCode().equals(other.getAreaDistrictCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCenter() == null ? other.getCenter() == null : this.getCenter().equals(other.getCenter()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getAreaDistrictCode() == null) ? 0 : getAreaDistrictCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCenter() == null) ? 0 : getCenter().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}