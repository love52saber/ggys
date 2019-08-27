package net.seocoo.ggys.module.book.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.book.constants.BookDetailStateEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class FreeBookDetailDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    private Integer merchantId;

    private Integer bookUserId;

    private String fullName;

    private String phone;

    private Integer freeBookRuleId;

    private String bookRemark;

    private BookDetailStateEnum bookState;

    private String rejectReason;

    private Date createDate;

    private Date updateDate;

    private String cancelReason;

    private Date useStartDate;

    private Date useEndDate;

    private Integer auditUserId;

    private Date auditDate;

    private Date cancelDate;

    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public FreeBookDetailDO(Integer id, String uuid, Integer merchantId, Integer bookUserId, String fullName, String phone, Integer freeBookRuleId, String bookRemark, BookDetailStateEnum bookState, String rejectReason, Date createDate, Date updateDate, String cancelReason, Date useStartDate, Date useEndDate, Integer auditUserId, Date auditDate, Date cancelDate, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.bookUserId = bookUserId;
        this.fullName = fullName;
        this.phone = phone;
        this.freeBookRuleId = freeBookRuleId;
        this.bookRemark = bookRemark;
        this.bookState = bookState;
        this.rejectReason = rejectReason;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.cancelReason = cancelReason;
        this.useStartDate = useStartDate;
        this.useEndDate = useEndDate;
        this.auditUserId = auditUserId;
        this.auditDate = auditDate;
        this.cancelDate = cancelDate;
        this.canDeleted = canDeleted;
    }

    public FreeBookDetailDO() {
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
     * set商户Id
     * @param merchantId
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * get预约用户id
     * @return 预约用户id
     */
    public Integer getBookUserId() {
        return bookUserId;
    }

    /**
     * set预约用户id
     * @param bookUserId
     */
    public void setBookUserId(Integer bookUserId) {
        this.bookUserId = bookUserId;
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
        this.phone = phone;
    }

    /**
     * get免费预约规则id
     * @return 免费预约规则id
     */
    public Integer getFreeBookRuleId() {
        return freeBookRuleId;
    }

    /**
     * set免费预约规则id
     * @param freeBookRuleId
     */
    public void setFreeBookRuleId(Integer freeBookRuleId) {
        this.freeBookRuleId = freeBookRuleId;
    }

    /**
     * get预约备注
     * @return 预约备注
     */
    public String getBookRemark() {
        return bookRemark;
    }

    /**
     * set预约备注
     * @param bookRemark
     */
    public void setBookRemark(String bookRemark) {
        this.bookRemark = bookRemark == null ? null : bookRemark.trim();
    }

    /**
     * get预约状态
     * @return 预约状态
     */
    public BookDetailStateEnum getBookState() {
        return bookState;
    }

    /**
     * set预约状态
     * @param bookState
     */
    public void setBookState(BookDetailStateEnum bookState) {
        this.bookState = bookState == null ? null : bookState;
    }

    /**
     * get拒绝理由
     * @return 拒绝理由
     */
    public String getRejectReason() {
        return rejectReason;
    }

    /**
     * set拒绝理由
     * @param rejectReason
     */
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
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
     * get取消理由
     * @return 取消理由
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * set取消理由
     * @param cancelReason
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    /**
     * get使用开始时间
     * @return 使用开始时间
     */
    public Date getUseStartDate() {
        return useStartDate;
    }

    /**
     * set使用开始时间
     * @param useStartDate
     */
    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }

    /**
     * get使用结束时间
     * @return 使用结束时间
     */
    public Date getUseEndDate() {
        return useEndDate;
    }

    /**
     * set使用结束时间
     * @param useEndDate
     */
    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    /**
     * get审核人
     * @return 审核人
     */
    public Integer getAuditUserId() {
        return auditUserId;
    }

    /**
     * set审核人
     * @param auditUserId
     */
    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    /**
     * get审核时间
     * @return 审核时间
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * set审核时间
     * @param auditDate
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * get取消时间
     * @return 取消时间
     */
    public Date getCancelDate() {
        return cancelDate;
    }

    /**
     * set取消时间
     * @param cancelDate
     */
    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
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
        FreeBookDetailDO other = (FreeBookDetailDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getBookUserId() == null ? other.getBookUserId() == null : this.getBookUserId().equals(other.getBookUserId()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getFreeBookRuleId() == null ? other.getFreeBookRuleId() == null : this.getFreeBookRuleId().equals(other.getFreeBookRuleId()))
            && (this.getBookRemark() == null ? other.getBookRemark() == null : this.getBookRemark().equals(other.getBookRemark()))
            && (this.getBookState() == null ? other.getBookState() == null : this.getBookState().equals(other.getBookState()))
            && (this.getRejectReason() == null ? other.getRejectReason() == null : this.getRejectReason().equals(other.getRejectReason()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCancelReason() == null ? other.getCancelReason() == null : this.getCancelReason().equals(other.getCancelReason()))
            && (this.getUseStartDate() == null ? other.getUseStartDate() == null : this.getUseStartDate().equals(other.getUseStartDate()))
            && (this.getUseEndDate() == null ? other.getUseEndDate() == null : this.getUseEndDate().equals(other.getUseEndDate()))
            && (this.getAuditUserId() == null ? other.getAuditUserId() == null : this.getAuditUserId().equals(other.getAuditUserId()))
            && (this.getAuditDate() == null ? other.getAuditDate() == null : this.getAuditDate().equals(other.getAuditDate()))
            && (this.getCancelDate() == null ? other.getCancelDate() == null : this.getCancelDate().equals(other.getCancelDate()))
            && (this.getCanDeleted() == null ? other.getCanDeleted() == null : this.getCanDeleted().equals(other.getCanDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getBookUserId() == null) ? 0 : getBookUserId().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getFreeBookRuleId() == null) ? 0 : getFreeBookRuleId().hashCode());
        result = prime * result + ((getBookRemark() == null) ? 0 : getBookRemark().hashCode());
        result = prime * result + ((getBookState() == null) ? 0 : getBookState().hashCode());
        result = prime * result + ((getRejectReason() == null) ? 0 : getRejectReason().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCancelReason() == null) ? 0 : getCancelReason().hashCode());
        result = prime * result + ((getUseStartDate() == null) ? 0 : getUseStartDate().hashCode());
        result = prime * result + ((getUseEndDate() == null) ? 0 : getUseEndDate().hashCode());
        result = prime * result + ((getAuditUserId() == null) ? 0 : getAuditUserId().hashCode());
        result = prime * result + ((getAuditDate() == null) ? 0 : getAuditDate().hashCode());
        result = prime * result + ((getCancelDate() == null) ? 0 : getCancelDate().hashCode());
        result = prime * result + ((getCanDeleted() == null) ? 0 : getCanDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}