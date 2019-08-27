package net.seocoo.ggys.module.book.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
/**
 * 免费预约DO实体
 *@author PanChengHao
 *@date 2018/6/4 19:44
 */

public class FreeBookRuleDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    private Integer merchantId;

    private Date bookStartDate;

    private Date bookEndDate;

    private Integer maxBookCount;

    private YesNoEnum canDisplay;

    private Integer manageUserId;

    private Date createDate;

    private Date updateDate;

    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private Integer createUserId;

    private Integer updateUserId;

    private static final long serialVersionUID = 1L;

    public FreeBookRuleDO(Integer id, String uuid, Integer merchantId, Date bookStartDate, Date bookEndDate, Integer maxBookCount, YesNoEnum canDisplay, Integer manageUserId, Date createDate, Date updateDate, YesNoEnum canDeleted, Integer createUserId, Integer updateUserId) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.bookStartDate = bookStartDate;
        this.bookEndDate = bookEndDate;
        this.maxBookCount = maxBookCount;
        this.canDisplay = canDisplay;
        this.manageUserId = manageUserId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.canDeleted = canDeleted;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
    }

    public FreeBookRuleDO() {
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
     * get商家id
     * @return 商家id
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * set商家id
     * @param merchantId
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * get预约开始时间
     * @return 预约开始时间
     */
    public Date getBookStartDate() {
        return bookStartDate;
    }

    /**
     * set预约开始时间
     * @param bookStartDate
     */
    public void setBookStartDate(Date bookStartDate) {
        this.bookStartDate = bookStartDate;
    }

    /**
     * get预约结束时间
     * @return 预约结束时间
     */
    public Date getBookEndDate() {
        return bookEndDate;
    }

    /**
     * set预约结束时间
     * @param bookEndDate
     */
    public void setBookEndDate(Date bookEndDate) {
        this.bookEndDate = bookEndDate;
    }

    /**
     * get最大可预约人数
     * @return 最大可预约人数
     */
    public Integer getMaxBookCount() {
        return maxBookCount;
    }

    /**
     * set最大可预约人数
     * @param maxBookCount
     */
    public void setMaxBookCount(Integer maxBookCount) {
        this.maxBookCount = maxBookCount;
    }

    /**
     * get是否展示
     * @return 是否展示
     */
    public YesNoEnum getCanDisplay() {
        return canDisplay;
    }

    /**
     * set是否展示
     * @param canDisplay
     */
    public void setCanDisplay(YesNoEnum canDisplay) {
        this.canDisplay = canDisplay == null ? null : canDisplay;
    }

    /**
     * get管理员Id
     * @return 管理员Id
     */
    public Integer getManageUserId() {
        return manageUserId;
    }

    /**
     * set 管理员id
     * @param manageUserId
     */
    public void setManageUserId(Integer manageUserId) {
        this.manageUserId = manageUserId;
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
     * @return
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

    /**
     * get状态
     * @return 状态
     */
    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    /**
     * set状态
     * @param canDeleted
     */
    public void setCanDeleted(YesNoEnum canDeleted) {
        this.canDeleted = canDeleted;
    }

    /**
     * get创建人id
     * @return 创建人id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * set创建人id
     * @param createUserId
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * get更新人id
     * @return 更新人id
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * set更新人id
     * @param updateUserId
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
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
        FreeBookRuleDO other = (FreeBookRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getBookStartDate() == null ? other.getBookStartDate() == null : this.getBookStartDate().equals(other.getBookStartDate()))
            && (this.getBookEndDate() == null ? other.getBookEndDate() == null : this.getBookEndDate().equals(other.getBookEndDate()))
            && (this.getMaxBookCount() == null ? other.getMaxBookCount() == null : this.getMaxBookCount().equals(other.getMaxBookCount()))
            && (this.getCanDisplay() == null ? other.getCanDisplay() == null : this.getCanDisplay().equals(other.getCanDisplay()))
            && (this.getManageUserId() == null ? other.getManageUserId() == null : this.getManageUserId().equals(other.getManageUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getBookStartDate() == null) ? 0 : getBookStartDate().hashCode());
        result = prime * result + ((getBookEndDate() == null) ? 0 : getBookEndDate().hashCode());
        result = prime * result + ((getMaxBookCount() == null) ? 0 : getMaxBookCount().hashCode());
        result = prime * result + ((getCanDisplay() == null) ? 0 : getCanDisplay().hashCode());
        result = prime * result + ((getManageUserId() == null) ? 0 : getManageUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}