package net.seocoo.ggys.module.groupon.entity;

import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
*@author:hengxie
*@date:2018/6/5 0005
*@description: 团购商品模板
*/
public class MerchantGrouponGoodsDTO implements Serializable {
    private Integer id;

    /**
     * 商品名
     */
    private String name;

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
     *商户名
     */
    private String merchantName;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    private YesNoEnum needBook;;

    public YesNoEnum getNeedBook() {
        return needBook;
    }

    public void setNeedBook(YesNoEnum needBook) {
        this.needBook = needBook;
    }

    public MerchantGrouponGoodsDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallImgUrl() {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl) {
        this.smallImgUrl = smallImgUrl;
    }

    public String getFirstLargeImgUrl() {
        return firstLargeImgUrl;
    }

    public void setFirstLargeImgUrl(String firstLargeImgUrl) {
        this.firstLargeImgUrl = firstLargeImgUrl;
    }

    public String getSecondLargeImgUrl() {
        return secondLargeImgUrl;
    }

    public void setSecondLargeImgUrl(String secondLargeImgUrl) {
        this.secondLargeImgUrl = secondLargeImgUrl;
    }

    public String getThirdLargeImgUrl() {
        return thirdLargeImgUrl;
    }

    public void setThirdLargeImgUrl(String thirdLargeImgUrl) {
        this.thirdLargeImgUrl = thirdLargeImgUrl;
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
        this.remark = remark;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}