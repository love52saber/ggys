package net.seocoo.ggys.module.takeout.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
*@author:hengxie
*@date:2018/6/5 0005
*@description: 外卖规则
*/
public class MerchantTakeOutRuleDO implements Serializable {
    private Integer id;

    private String uuid;

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 是否支持自取
     */
    private YesNoEnum canSelfTake;

    /**
     * 配送范围
     */
    private Double deliveryRange;

    /**
     * 配送费
     */
    private BigDecimal deliveryFee;

    /**
     * 包装费
     */
    private BigDecimal packageFee;

    /**
     * 管理员
     */
    private Integer manageUserId;

    /**
     * 外卖开始时间
     */
    private Date deliveryStartDate;

    /**
     * 外卖结束时间
     */
    private Date deliveryEndDate;

    /**
     * 外卖状态,是,否
     */
    private YesNoEnum ruleState;

    private Date createDate;

    private Integer createUserId;

    private Date updateDate;

    private Integer updateUserId;

    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MerchantTakeOutRuleDO(Integer id, String uuid, Integer merchantId, YesNoEnum canSelfTake, Double deliveryRange, BigDecimal deliveryFee, BigDecimal packageFee, Integer manageUserId, Date deliveryStartDate, Date deliveryEndDate, YesNoEnum ruleState, Date createDate, Integer createUserId, Date updateDate, Integer updateUserId, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.canSelfTake = canSelfTake;
        this.deliveryRange = deliveryRange;
        this.deliveryFee = deliveryFee;
        this.packageFee = packageFee;
        this.manageUserId = manageUserId;
        this.deliveryStartDate = deliveryStartDate;
        this.deliveryEndDate = deliveryEndDate;
        this.ruleState = ruleState;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.updateDate = updateDate;
        this.updateUserId = updateUserId;
        this.canDeleted = canDeleted;
    }

    public MerchantTakeOutRuleDO() {
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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public YesNoEnum getCanSelfTake() {
        return canSelfTake;
    }

    public void setCanSelfTake(YesNoEnum canSelfTake) {
        this.canSelfTake = canSelfTake;
    }

    public Double getDeliveryRange() {
        return deliveryRange;
    }

    public void setDeliveryRange(Double deliveryRange) {
        this.deliveryRange = deliveryRange;
    }

    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigDecimal getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(BigDecimal packageFee) {
        this.packageFee = packageFee;
    }

    public Integer getManageUserId() {
        return manageUserId;
    }

    public void setManageUserId(Integer manageUserId) {
        this.manageUserId = manageUserId;
    }

    public Date getDeliveryStartDate() {
        return deliveryStartDate;
    }

    public void setDeliveryStartDate(Date deliveryStartDate) {
        this.deliveryStartDate = deliveryStartDate;
    }

    public Date getDeliveryEndDate() {
        return deliveryEndDate;
    }

    public void setDeliveryEndDate(Date deliveryEndDate) {
        this.deliveryEndDate = deliveryEndDate;
    }

    public YesNoEnum getRuleState() {
        return ruleState;
    }

    public void setRuleState(YesNoEnum ruleState) {
        this.ruleState = ruleState;
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
        MerchantTakeOutRuleDO other = (MerchantTakeOutRuleDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getCanSelfTake() == null ? other.getCanSelfTake() == null : this.getCanSelfTake().equals(other.getCanSelfTake()))
            && (this.getDeliveryRange() == null ? other.getDeliveryRange() == null : this.getDeliveryRange().equals(other.getDeliveryRange()))
            && (this.getDeliveryFee() == null ? other.getDeliveryFee() == null : this.getDeliveryFee().equals(other.getDeliveryFee()))
            && (this.getPackageFee() == null ? other.getPackageFee() == null : this.getPackageFee().equals(other.getPackageFee()))
            && (this.getManageUserId() == null ? other.getManageUserId() == null : this.getManageUserId().equals(other.getManageUserId()))
            && (this.getDeliveryStartDate() == null ? other.getDeliveryStartDate() == null : this.getDeliveryStartDate().equals(other.getDeliveryStartDate()))
            && (this.getDeliveryEndDate() == null ? other.getDeliveryEndDate() == null : this.getDeliveryEndDate().equals(other.getDeliveryEndDate()))
            && (this.getRuleState() == null ? other.getRuleState() == null : this.getRuleState().equals(other.getRuleState()))
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
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getCanSelfTake() == null) ? 0 : getCanSelfTake().hashCode());
        result = prime * result + ((getDeliveryRange() == null) ? 0 : getDeliveryRange().hashCode());
        result = prime * result + ((getDeliveryFee() == null) ? 0 : getDeliveryFee().hashCode());
        result = prime * result + ((getPackageFee() == null) ? 0 : getPackageFee().hashCode());
        result = prime * result + ((getManageUserId() == null) ? 0 : getManageUserId().hashCode());
        result = prime * result + ((getDeliveryStartDate() == null) ? 0 : getDeliveryStartDate().hashCode());
        result = prime * result + ((getDeliveryEndDate() == null) ? 0 : getDeliveryEndDate().hashCode());
        result = prime * result + ((getRuleState() == null) ? 0 : getRuleState().hashCode());
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