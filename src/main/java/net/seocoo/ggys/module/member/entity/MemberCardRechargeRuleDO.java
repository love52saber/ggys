package net.seocoo.ggys.module.member.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberCardRechargeRuleDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    //商户id
    private Integer merchantId;

    //充值金额
    private BigDecimal rechargeMoney;

    //赠送金额
    private BigDecimal giftMoney;

    //排序号
    private Integer sortNumber;

    //创建人id
    private Integer createUserId;

    //更新人id
    private Integer updateUserId;

    //创建时间
    private Date createDate;

    //更新时间
    private Date updateDate;

    //状态
    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MemberCardRechargeRuleDO(Integer id, String uuid, Integer merchantId, BigDecimal rechargeMoney, BigDecimal giftMoney, Integer sortNumber, Integer createUserId, Integer updateUserId, Date createDate, Date updateDate, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.rechargeMoney = rechargeMoney;
        this.giftMoney = giftMoney;
        this.sortNumber = sortNumber;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.canDeleted = canDeleted;
    }

    public MemberCardRechargeRuleDO() {
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
     * get商户id
     * @return 商户id
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * set商户id
     * @param merchantId
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * get充值金额
     * @return
     */
    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    /**
     * set商户id
     * @param rechargeMoney
     */
    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    /**
     * get赠送金额
     * @return 赠送金额
     */
    public BigDecimal getGiftMoney() {
        return giftMoney;
    }

    /**
     * set赠送金额
     * @param giftMoney
     */
    public void setGiftMoney(BigDecimal giftMoney) {
        this.giftMoney = giftMoney;
    }

    /**
     * get排序号
     * @return 排序号
     */
    public Integer getSortNumber() {
        return sortNumber;
    }

    /**
     * set排序号
     * @param sortNumber
     */
    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
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
        MemberCardRechargeRuleDO other = (MemberCardRechargeRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getRechargeMoney() == null ? other.getRechargeMoney() == null : this.getRechargeMoney().equals(other.getRechargeMoney()))
            && (this.getGiftMoney() == null ? other.getGiftMoney() == null : this.getGiftMoney().equals(other.getGiftMoney()))
            && (this.getSortNumber() == null ? other.getSortNumber() == null : this.getSortNumber().equals(other.getSortNumber()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getRechargeMoney() == null) ? 0 : getRechargeMoney().hashCode());
        result = prime * result + ((getGiftMoney() == null) ? 0 : getGiftMoney().hashCode());
        result = prime * result + ((getSortNumber() == null) ? 0 : getSortNumber().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}