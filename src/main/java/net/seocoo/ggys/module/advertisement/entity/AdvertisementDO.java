package net.seocoo.ggys.module.advertisement.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.advertisement.constans.PutInTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class AdvertisementDO implements Serializable {
    private Integer id;

    private String name;

    private String imgUrl;

    private PutInTypeEnum putInType;

    private String putInZone;

    private Date putInStartDate;

    private Date putInEndDate;

    private YesNoEnum state;

    private Date createDate;

    private Integer createUserId;

    private Date updateDate;

    private Integer updateUserId;

    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;


    public AdvertisementDO() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getPutInZone() {
        return putInZone;
    }

    public void setPutInZone(String putInZone) {
        this.putInZone = putInZone == null ? null : putInZone.trim();
    }

    public Date getPutInStartDate() {
        return putInStartDate;
    }

    public void setPutInStartDate(Date putInStartDate) {
        this.putInStartDate = putInStartDate;
    }

    public Date getPutInEndDate() {
        return putInEndDate;
    }

    public void setPutInEndDate(Date putInEndDate) {
        this.putInEndDate = putInEndDate;
    }


    public YesNoEnum getState() {
        return state;
    }

    public void setState(YesNoEnum state) {
        this.state = state;
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

    public PutInTypeEnum getPutInType() {
        return putInType;
    }

    public void setPutInType(PutInTypeEnum putInType) {
        this.putInType = putInType;
    }

    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    public void setCanDeleted(YesNoEnum canDeleted) {
        this.canDeleted = canDeleted;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}