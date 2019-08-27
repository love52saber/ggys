package net.seocoo.ggys.module.member.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.PayTypeEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberCardRechargeRecordDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    //商户id
    private Integer merchantId;

    //用户id
    private Integer userId;

    //会员卡id
    private Integer memberCardId;

    //交易流水号
    private String transactionNo;

    //充值金额
    private BigDecimal rechargeMoney;

    //赠送金额
    private BigDecimal giftMoney;

    //充值总金额
    private BigDecimal rechargeTotalMoney;

    //余额
    private BigDecimal remainingMoney;

    //充值时间
    private Date rechargeDate;

    //支付类型
    private PayTypeEnum payType;

    //创建时间
    private Date createDate;

    //是否删除
    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MemberCardRechargeRecordDO(Integer id, String uuid, Integer merchantId, Integer userId, Integer memberCardId, String transactionNo, BigDecimal rechargeMoney, BigDecimal giftMoney, BigDecimal rechargeTotalMoney, BigDecimal remainingMoney, Date rechargeDate, String payState, PayTypeEnum payType, Date createDate, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.userId = userId;
        this.memberCardId = memberCardId;
        this.transactionNo = transactionNo;
        this.rechargeMoney = rechargeMoney;
        this.giftMoney = giftMoney;
        this.rechargeTotalMoney = rechargeTotalMoney;
        this.remainingMoney = remainingMoney;
        this.rechargeDate = rechargeDate;
        this.payType = payType;
        this.createDate = createDate;
        this.canDeleted = canDeleted;
    }

    public MemberCardRechargeRecordDO() {
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
     * geta用户id
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * set用户id
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
     * set会员卡id
     * @param memberCardId
     */
    public void setMemberCardId(Integer memberCardId) {
        this.memberCardId = memberCardId;
    }

    /**
     * get交易流水号
     * @return 交易流水号
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * set交易流水号
     * @param transactionNo
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo == null ? null : transactionNo.trim();
    }

    /**
     * get充值金额
     * @return 充值金额
     */
    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    /**
     * set充值金额
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
     * get充值总金额
     * @return 充值总金额
     */
    public BigDecimal getRechargeTotalMoney() {
        return rechargeTotalMoney;
    }

    /**
     * set充值总金额
     * @param rechargeTotalMoney
     */
    public void setRechargeTotalMoney(BigDecimal rechargeTotalMoney) {
        this.rechargeTotalMoney = rechargeTotalMoney;
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
     * get充值时间
     * @return 充值时间
     */
    public Date getRechargeDate() {
        return rechargeDate;
    }

    /**
     * set充值时间
     * @param rechargeDate
     */
    public void setRechargeDate(Date rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    /**
     * get支付类型
     * @return 支付类型
     */
    public PayTypeEnum getPayType() {
        return payType;
    }

    /**
     * set支付类型
     * @param payType
     */
    public void setPayType(PayTypeEnum payType) {
        this.payType = payType == null ? null : payType;
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
        MemberCardRechargeRecordDO other = (MemberCardRechargeRecordDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMemberCardId() == null ? other.getMemberCardId() == null : this.getMemberCardId().equals(other.getMemberCardId()))
            && (this.getTransactionNo() == null ? other.getTransactionNo() == null : this.getTransactionNo().equals(other.getTransactionNo()))
            && (this.getRechargeMoney() == null ? other.getRechargeMoney() == null : this.getRechargeMoney().equals(other.getRechargeMoney()))
            && (this.getGiftMoney() == null ? other.getGiftMoney() == null : this.getGiftMoney().equals(other.getGiftMoney()))
            && (this.getRechargeTotalMoney() == null ? other.getRechargeTotalMoney() == null : this.getRechargeTotalMoney().equals(other.getRechargeTotalMoney()))
            && (this.getRemainingMoney() == null ? other.getRemainingMoney() == null : this.getRemainingMoney().equals(other.getRemainingMoney()))
            && (this.getRechargeDate() == null ? other.getRechargeDate() == null : this.getRechargeDate().equals(other.getRechargeDate()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
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
        result = prime * result + ((getTransactionNo() == null) ? 0 : getTransactionNo().hashCode());
        result = prime * result + ((getRechargeMoney() == null) ? 0 : getRechargeMoney().hashCode());
        result = prime * result + ((getGiftMoney() == null) ? 0 : getGiftMoney().hashCode());
        result = prime * result + ((getRechargeTotalMoney() == null) ? 0 : getRechargeTotalMoney().hashCode());
        result = prime * result + ((getRemainingMoney() == null) ? 0 : getRemainingMoney().hashCode());
        result = prime * result + ((getRechargeDate() == null) ? 0 : getRechargeDate().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}