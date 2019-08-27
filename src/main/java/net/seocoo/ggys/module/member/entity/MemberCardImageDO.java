package net.seocoo.ggys.module.member.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;

import java.io.Serializable;
import java.util.Date;

public class MemberCardImageDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    @JSONField(serialize = false)
    private String name;

    private Integer merchantId;

    private String memberCardImageUrl;

    private String memberCardDescription;

    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    @JSONField(serialize = false)
    private Date createDate;

    @JSONField(serialize = false)
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public MemberCardImageDO(Integer id, String uuid, String name, Integer merchantId, String memberCardImageUrl, String memberCardDescription, YesNoEnum canDeleted, Date createDate, Date updateDate) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.merchantId = merchantId;
        this.memberCardImageUrl = memberCardImageUrl;
        this.memberCardDescription = memberCardDescription;
        this.canDeleted = canDeleted;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public MemberCardImageDO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getMemberCardImageUrl() {
        return memberCardImageUrl;
    }

    public void setMemberCardImageUrl(String memberCardImageUrl) {
        this.memberCardImageUrl = memberCardImageUrl == null ? null : memberCardImageUrl.trim();
    }

    public String getMemberCardDescription() {
        return memberCardDescription;
    }

    public void setMemberCardDescription(String memberCardDescription) {
        this.memberCardDescription = memberCardDescription == null ? null : memberCardDescription.trim();
    }

    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    public void setCanDeleted(YesNoEnum canDeleted) {
        this.canDeleted = canDeleted == null ? null : canDeleted;
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
        MemberCardImageDO other = (MemberCardImageDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getMemberCardImageUrl() == null ? other.getMemberCardImageUrl() == null : this.getMemberCardImageUrl().equals(other.getMemberCardImageUrl()))
            && (this.getMemberCardDescription() == null ? other.getMemberCardDescription() == null : this.getMemberCardDescription().equals(other.getMemberCardDescription()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getMemberCardImageUrl() == null) ? 0 : getMemberCardImageUrl().hashCode());
        result = prime * result + ((getMemberCardDescription() == null) ? 0 : getMemberCardDescription().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}