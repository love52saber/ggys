package net.seocoo.ggys.module.member.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.SexEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberCardInfoDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    //商户id
    private Integer merchantId;

    //会员卡编号
    private String memberCardNo;

    //用户id
    private Integer userId;

    //用户姓名
    private String fullName;

    //手机号
    private String phone;

    //性别
    private SexEnum sex;

    //生日
    private Date birthday;

    //余额
    private BigDecimal remainingMoney;

    //创建时间
    private Date createDate;

    //更新时间
    private Date updateDate;

    //状态
    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    //充值总金额
    private BigDecimal rechargeTotalMoney;

    private static final long serialVersionUID = 1L;

    public MemberCardInfoDO(Integer id, String uuid, Integer merchantId, String memberCardNo, Integer userId, String fullName, String phone, SexEnum sex, Date birthday, BigDecimal remainingMoney, Date createDate, Date updateDate, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.memberCardNo = memberCardNo;
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.remainingMoney = remainingMoney;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.canDeleted = canDeleted;
    }

    public MemberCardInfoDO() {
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
     * get会员卡编号
     * @return 会员卡编号
     */
    public String getMemberCardNo() {
        return memberCardNo;
    }

    /**
     * set会员卡编号
     * @param memberCardNo
     */
    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    /**
     * get用户id
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
     * get姓名
     * @return 姓名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * set姓名
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * get手机号
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set手机号
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * get性别
     * @return 性别
     */
    public SexEnum getSex() {
        return sex;
    }

    /**
     * set性别
     * @param sex
     */
    public void setSex(SexEnum sex) {
        this.sex = sex == null ? null : sex;
    }

    /**
     * get生日
     * @return 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * set生日
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public BigDecimal getRechargeTotalMoney() {
        return rechargeTotalMoney;
    }

    public void setRechargeTotalMoney(BigDecimal rechargeTotalMoney) {
        this.rechargeTotalMoney = rechargeTotalMoney;
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
        MemberCardInfoDO other = (MemberCardInfoDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getMemberCardNo() == null ? other.getMemberCardNo() == null : this.getMemberCardNo().equals(other.getMemberCardNo()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getRemainingMoney() == null ? other.getRemainingMoney() == null : this.getRemainingMoney().equals(other.getRemainingMoney()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()))
            && (this.getRechargeTotalMoney() == null ? other.getRechargeTotalMoney() == null : this.getRechargeTotalMoney().equals(other.getRechargeTotalMoney()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getMemberCardNo() == null) ? 0 : getMemberCardNo().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getRemainingMoney() == null) ? 0 : getRemainingMoney().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        result = prime * result + ((getRechargeTotalMoney() == null) ? 0 : getRechargeTotalMoney().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}