package net.seocoo.ggys.module.groupon.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
/**
*@author:hengxie
*@date:2018/6/5 0005
*@description: 团购商品模板图片
*/
public class MerchantGrouponTemplatePictureDO implements Serializable {
    private Integer id;

    private String uuid;

    private String picType;

    private String imgPath;

    /**
     * 团购商品模板id
     */
    private Integer merchantGrouponTemplateId;

    private Date createDate;

    private Integer createUserId;

    private Date updateDate;

    private Integer updateUserId;

    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MerchantGrouponTemplatePictureDO(Integer id, String uuid, String picType, String imgPath, Integer merchantGrouponTemplateId, Date createDate, Integer createUserId, Date updateDate, Integer updateUserId, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.picType = picType;
        this.imgPath = imgPath;
        this.merchantGrouponTemplateId = merchantGrouponTemplateId;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.updateDate = updateDate;
        this.updateUserId = updateUserId;
        this.canDeleted = canDeleted;
    }

    public MerchantGrouponTemplatePictureDO() {
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

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType == null ? null : picType.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Integer getMerchantGrouponTemplateId() {
        return merchantGrouponTemplateId;
    }

    public void setMerchantGrouponTemplateId(Integer merchantGrouponTemplateId) {
        this.merchantGrouponTemplateId = merchantGrouponTemplateId;
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
        MerchantGrouponTemplatePictureDO other = (MerchantGrouponTemplatePictureDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getPicType() == null ? other.getPicType() == null : this.getPicType().equals(other.getPicType()))
            && (this.getImgPath() == null ? other.getImgPath() == null : this.getImgPath().equals(other.getImgPath()))
            && (this.getMerchantGrouponTemplateId() == null ? other.getMerchantGrouponTemplateId() == null : this.getMerchantGrouponTemplateId().equals(other.getMerchantGrouponTemplateId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getPicType() == null) ? 0 : getPicType().hashCode());
        result = prime * result + ((getImgPath() == null) ? 0 : getImgPath().hashCode());
        result = prime * result + ((getMerchantGrouponTemplateId() == null) ? 0 : getMerchantGrouponTemplateId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}