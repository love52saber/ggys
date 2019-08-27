package net.seocoo.ggys.module.evaluate.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.evaluate.constants.OrderEvaluateResultEnum;
import net.seocoo.ggys.module.order.constants.OrderTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class OrderEvaluateDO implements Serializable {
    private Integer id;

    @JSONField(serialize = false)
    private String uuid;

    //用户id
    private Integer userId;

    //商户id
    private Integer merchantId;

    //订单id
    private Integer orderId;

    private String orderNo;

    private OrderTypeEnum orderType;

    //评价结果
    private OrderEvaluateResultEnum evaluateResult;

    //具体评价内容
    private String content;

    //创建时间
    private Date createDate;

    //更新时间
    private Date updateDate;

    @JSONField(serialize = false)
    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public OrderEvaluateDO(Integer id, String uuid, Integer userId, Integer merchantId, Integer orderId, String orderNo, OrderTypeEnum orderType, OrderEvaluateResultEnum evaluateResult, String content, Date createDate, Date updateDate, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.userId = userId;
        this.merchantId = merchantId;
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.evaluateResult = evaluateResult;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.canDeleted = canDeleted;
    }

    public OrderEvaluateDO() {
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
     * get用户Id
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
     * get订单号
     * @return
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * set订单号
     * @param orderNo
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * get订单类型
     * @return
     */
    public OrderTypeEnum getOrderType() {
        return orderType;
    }

    /**
     * set订单类型
     * @param orderType
     */
    public void setOrderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
    }

    /**
     * get评价结果
     * @return 评价结果
     */
    public OrderEvaluateResultEnum getEvaluateResult() {
        return evaluateResult;
    }

    /**
     * set评价结果
     * @param evaluateResult
     */
    public void setEvaluateResult(OrderEvaluateResultEnum evaluateResult) {
        this.evaluateResult = evaluateResult == null ? null : evaluateResult;
    }

    /**
     * get评价具体内容
     * @return 评价具体内容
     */
    public String getContent() {
        return content;
    }

    /**
     * set评价内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        OrderEvaluateDO other = (OrderEvaluateDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
            && (this.getEvaluateResult() == null ? other.getEvaluateResult() == null : this.getEvaluateResult().equals(other.getEvaluateResult()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
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
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        result = prime * result + ((getEvaluateResult() == null) ? 0 : getEvaluateResult().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
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