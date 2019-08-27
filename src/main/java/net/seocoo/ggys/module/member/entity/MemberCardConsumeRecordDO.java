package net.seocoo.ggys.module.member.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberCardConsumeRecordDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    //商户id
    private Integer merchantId;

    //用户id
    private Integer userId;

    //会员卡id
    private Integer memberCardId;

    //订单id
    private Integer orderId;

    //消费金额
    private BigDecimal consumeMoney;

    //余额
    private BigDecimal remainingMoney;

    //消费时间
    private Date consumeDate;

    //是否删除
    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MemberCardConsumeRecordDO(Integer id, String uuid, Integer merchantId, Integer userId, Integer memberCardId, Integer orderId, BigDecimal consumeMoney, BigDecimal remainingMoney, Date consumeDate, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.userId = userId;
        this.memberCardId = memberCardId;
        this.orderId = orderId;
        this.consumeMoney = consumeMoney;
        this.remainingMoney = remainingMoney;
        this.consumeDate = consumeDate;
        this.canDeleted = canDeleted;
    }

    public MemberCardConsumeRecordDO() {
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
     * get用户id
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * set商户id
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * get会员卡id
     * @return 会员卡id
     */
    public Integer getMemberCardId() {
        return memberCardId;
    }

    /**
     * set商户id
     * @param memberCardId
     */
    public void setMemberCardId(Integer memberCardId) {
        this.memberCardId = memberCardId;
    }

    /**
     * get订单id
     * @return 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * set订单id
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * get消费金额
     * @return 消费金额
     */
    public BigDecimal getConsumeMoney() {
        return consumeMoney;
    }

    /**
     * set消费金额
     * @param consumeMoney
     */
    public void setConsumeMoney(BigDecimal consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    /**
     * get余额
     * @return 余额
     */
    public BigDecimal getRemainingMoney() {
        return remainingMoney;
    }

    /**
     * set余额
     * @param remainingMoney
     */
    public void setRemainingMoney(BigDecimal remainingMoney) {
        this.remainingMoney = remainingMoney;
    }

    /**
     * get消费时间
     * @return 消费时间
     */
    public Date getConsumeDate() {
        return consumeDate;
    }

    /**
     * set消费时间
     * @param consumeDate
     */
    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    /**
     * get是否删除
     * @return
     */
    public YesNoEnum getCanDeleted() {
        return canDeleted;
    }

    /**
     * set是否删除
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
        MemberCardConsumeRecordDO other = (MemberCardConsumeRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMemberCardId() == null ? other.getMemberCardId() == null : this.getMemberCardId().equals(other.getMemberCardId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getConsumeMoney() == null ? other.getConsumeMoney() == null : this.getConsumeMoney().equals(other.getConsumeMoney()))
            && (this.getRemainingMoney() == null ? other.getRemainingMoney() == null : this.getRemainingMoney().equals(other.getRemainingMoney()))
            && (this.getConsumeDate() == null ? other.getConsumeDate() == null : this.getConsumeDate().equals(other.getConsumeDate()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMemberCardId() == null) ? 0 : getMemberCardId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getConsumeMoney() == null) ? 0 : getConsumeMoney().hashCode());
        result = prime * result + ((getRemainingMoney() == null) ? 0 : getRemainingMoney().hashCode());
        result = prime * result + ((getConsumeDate() == null) ? 0 : getConsumeDate().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}