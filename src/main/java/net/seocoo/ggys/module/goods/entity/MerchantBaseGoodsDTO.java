package net.seocoo.ggys.module.goods.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.module.goods.constans.GoodsStateEnum;
import net.seocoo.ggys.module.goods.constans.GoodsTypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author xieheng
 * @Data 2018/6/6 0006 10:49
 * @Email xieheng91@163.com
 * @Desc 商品前台获取对象
 */
public class MerchantBaseGoodsDTO implements Serializable {

    /**
     * DO外字段
     */
    /**
     * 商户名称(店铺名称)
     */
    private String merchantName;
    /**
     * 所属分类
     */
    private GoodsTypeEnum type;




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
     * 审核状态
     */
    private GoodsStateEnum state;

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
     * 最低价格
     */
    private BigDecimal minPrice;

    /**
     * 是否显示
     */
    private YesNoEnum canDisplay;

    /**
     * 是否需要预约
     */
    private YesNoEnum needBook;

    private Date createDate;

    private Integer createUserId;

    private Date updateDate;

    private Integer updateUserId;

    private YesNoEnum canDeleted;

    private static final long serialVersionUID = 1L;

    public MerchantBaseGoodsDTO() {
        super();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public GoodsTypeEnum getType() {
        return type;
    }

    public void setType(GoodsTypeEnum type) {
        this.type = type;
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

    public YesNoEnum getNeedBook() {
        return needBook;
    }

    public void setNeedBook(YesNoEnum needBook) {
        this.needBook = needBook;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}
