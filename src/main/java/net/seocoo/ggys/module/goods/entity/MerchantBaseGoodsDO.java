package net.seocoo.ggys.module.goods.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.goods.constans.GoodsStateEnum;
import net.seocoo.ggys.module.goods.constans.GoodsTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
*@author:hengxie
*@date:2018/6/5 0005
*@description: 商品对象
*/
public class MerchantBaseGoodsDO implements Serializable {
    private Integer id;

    private String uuid;

    /**
     * 商户id
     */
    private Integer merchantId;

    /**
     * 商品名
     */
    private String name;

    /**
     *审核状态
     */
    private GoodsStateEnum state;

    /**
     *商品类型
     */
    private GoodsTypeEnum type;

    /**
     * 审核人
     */
    private Integer auditUserId;
    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 审核结果
     */
    private String auditResult;

    /**
     * 小图
     */
    private String smallImgUrl;

    /**
     * 第一张大图
     */
    private String firstLargeImgUrl;

    /**
     * 第二张大图url
     */
    private String secondLargeImgUrl;

    /**
     * 第三张大图url
     */
    private String thirdLargeImgUrl;

    /**
     * 排序号
     */
    private Integer sortNumber;

    /**
     * 当前价格
     */
    private BigDecimal currentPrice;

    /**
     * 原价格
     */
    private BigDecimal originalPrice;

    /**
     * 商品描述
     */
    private String remark;

    /**
     *最低价格
     */
    private BigDecimal minPrice;

    /**
     * 是否需要预约,团购商品使用
     */
    private YesNoEnum needBook;
    /**
     * 是否显示,外卖商品使用
     */
    private YesNoEnum canDisplay;
    /**
     * 外卖分类id,外卖商品使用
     */
    private Integer merchantTakeOutTypeId;

    private Date createDate;

    private Integer createUserId;

    private Date updateDate;

    private Integer updateUserId;

    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MerchantBaseGoodsDO(Integer id, String uuid, Integer merchantId, String name, GoodsTypeEnum type, GoodsStateEnum state, Integer auditUserId, Date auditDate, String auditResult, String smallImgUrl, String firstLargeImgUrl, String secondLargeImgUrl, String thirdLargeImgUrl, Integer sortNumber, BigDecimal currentPrice, BigDecimal originalPrice, String remark, BigDecimal minPrice, YesNoEnum canDisplay, Date createDate, Integer createUserId, Date updateDate, Integer updateUserId, YesNoEnum canDeleted) {
        this.id = id;
        this.uuid = uuid;
        this.merchantId = merchantId;
        this.name = name;
        this.type = type;
        this.state = state;
        this.auditUserId = auditUserId;
        this.auditDate = auditDate;
        this.auditResult = auditResult;
        this.smallImgUrl = smallImgUrl;
        this.firstLargeImgUrl = firstLargeImgUrl;
        this.secondLargeImgUrl = secondLargeImgUrl;
        this.thirdLargeImgUrl = thirdLargeImgUrl;
        this.sortNumber = sortNumber;
        this.currentPrice = currentPrice;
        this.originalPrice = originalPrice;
        this.remark = remark;
        this.minPrice = minPrice;
        this.canDisplay = canDisplay;
        this.createDate = createDate;
        this.createUserId = createUserId;
        this.updateDate = updateDate;
        this.updateUserId = updateUserId;
        this.canDeleted = canDeleted;
    }

    public MerchantBaseGoodsDO() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public GoodsStateEnum getState() {
        return state;
    }

    public void setState(GoodsStateEnum state) {
        this.state = state;
    }

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult == null ? null : auditResult.trim();
    }

    public String getSmallImgUrl() {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl) {
        this.smallImgUrl = smallImgUrl == null ? null : smallImgUrl.trim();
    }

    public String getFirstLargeImgUrl() {
        return firstLargeImgUrl;
    }

    public void setFirstLargeImgUrl(String firstLargeImgUrl) {
        this.firstLargeImgUrl = firstLargeImgUrl == null ? null : firstLargeImgUrl.trim();
    }

    public String getSecondLargeImgUrl() {
        return secondLargeImgUrl;
    }

    public void setSecondLargeImgUrl(String secondLargeImgUrl) {
        this.secondLargeImgUrl = secondLargeImgUrl == null ? null : secondLargeImgUrl.trim();
    }

    public String getThirdLargeImgUrl() {
        return thirdLargeImgUrl;
    }

    public void setThirdLargeImgUrl(String thirdLargeImgUrl) {
        this.thirdLargeImgUrl = thirdLargeImgUrl == null ? null : thirdLargeImgUrl.trim();
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public YesNoEnum getCanDisplay() {
        return canDisplay;
    }

    public void setCanDisplay(YesNoEnum canDisplay) {
        this.canDisplay = canDisplay;
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


    public GoodsTypeEnum getType() {
        return type;
    }

    public void setType(GoodsTypeEnum type) {
        this.type = type;
    }


    public YesNoEnum getNeedBook() {
        return needBook;
    }

    public void setNeedBook(YesNoEnum needBook) {
        this.needBook = needBook;
    }

    public Integer getMerchantTakeOutTypeId() {
        return merchantTakeOutTypeId;
    }

    public void setMerchantTakeOutTypeId(Integer merchantTakeOutTypeId) {
        this.merchantTakeOutTypeId = merchantTakeOutTypeId;
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
        MerchantBaseGoodsDO other = (MerchantBaseGoodsDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
                && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getAuditUserId() == null ? other.getAuditUserId() == null : this.getAuditUserId().equals(other.getAuditUserId()))
                && (this.getAuditDate() == null ? other.getAuditDate() == null : this.getAuditDate().equals(other.getAuditDate()))
                && (this.getAuditResult() == null ? other.getAuditResult() == null : this.getAuditResult().equals(other.getAuditResult()))
                && (this.getSmallImgUrl() == null ? other.getSmallImgUrl() == null : this.getSmallImgUrl().equals(other.getSmallImgUrl()))
                && (this.getFirstLargeImgUrl() == null ? other.getFirstLargeImgUrl() == null : this.getFirstLargeImgUrl().equals(other.getFirstLargeImgUrl()))
                && (this.getSecondLargeImgUrl() == null ? other.getSecondLargeImgUrl() == null : this.getSecondLargeImgUrl().equals(other.getSecondLargeImgUrl()))
                && (this.getThirdLargeImgUrl() == null ? other.getThirdLargeImgUrl() == null : this.getThirdLargeImgUrl().equals(other.getThirdLargeImgUrl()))
                && (this.getSortNumber() == null ? other.getSortNumber() == null : this.getSortNumber().equals(other.getSortNumber()))
                && (this.getCurrentPrice() == null ? other.getCurrentPrice() == null : this.getCurrentPrice().equals(other.getCurrentPrice()))
                && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getMinPrice() == null ? other.getMinPrice() == null : this.getMinPrice().equals(other.getMinPrice()))
                && (this.getCanDisplay() == null ? other.getCanDisplay() == null : this.getCanDisplay().equals(other.getCanDisplay()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getAuditUserId() == null) ? 0 : getAuditUserId().hashCode());
        result = prime * result + ((getAuditDate() == null) ? 0 : getAuditDate().hashCode());
        result = prime * result + ((getAuditResult() == null) ? 0 : getAuditResult().hashCode());
        result = prime * result + ((getSmallImgUrl() == null) ? 0 : getSmallImgUrl().hashCode());
        result = prime * result + ((getFirstLargeImgUrl() == null) ? 0 : getFirstLargeImgUrl().hashCode());
        result = prime * result + ((getSecondLargeImgUrl() == null) ? 0 : getSecondLargeImgUrl().hashCode());
        result = prime * result + ((getThirdLargeImgUrl() == null) ? 0 : getThirdLargeImgUrl().hashCode());
        result = prime * result + ((getSortNumber() == null) ? 0 : getSortNumber().hashCode());
        result = prime * result + ((getCurrentPrice() == null) ? 0 : getCurrentPrice().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getMinPrice() == null) ? 0 : getMinPrice().hashCode());
        result = prime * result + ((getCanDisplay() == null) ? 0 : getCanDisplay().hashCode());
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