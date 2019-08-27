package net.seocoo.ggys.module.groupon.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.constants.YesNoEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author xieheng
 * @Data 2018/6/7 0007 14:46
 * @Email xieheng91@163.com
 * @Desc 团购商品表单
 */
@ApiModel(value = "团购商品表单")
public class GrouponGoodsForm implements Serializable {

    private Integer id;

    /**
     * 是否需要预约
     */
    @ApiModelProperty(value = "是否需要预约")
    private YesNoEnum needBook;


    /**
     * 商品名
     */
    @NotBlank(message = "商品名不能为空")
    @ApiModelProperty(value = "商品名")
    private String name;

    /**
     * 小图
     */
    @ApiModelProperty(value = "小图")
    private String smallImgUrl;

    /**
     * 第一张大图
     */
    @ApiModelProperty(value = "第一张大图url")
    private String firstLargeImgUrl;

    /**
     * 第二张大图url
     */
    @ApiModelProperty(value = "第二张大图url")
    private String secondLargeImgUrl;

    /**
     * 第三张大图url
     */
    @ApiModelProperty(value = "第三张大图url")
    private String thirdLargeImgUrl;

    /**
     * 排序号
     */
    @ApiModelProperty(value = "排序号")
    private Integer sortNumber;
    /**
     * 当前价格
     */
    @ApiModelProperty(value = "现价")
    private BigDecimal currentPrice;

    /**
     * 原价格
     */
    @ApiModelProperty(value = "原价")
    private BigDecimal originalPrice;


    /**
     * 商品描述
     */
    @NotBlank
    @ApiModelProperty(value = "商品描述")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public YesNoEnum getNeedBook() {
        return needBook;
    }

    public void setNeedBook(YesNoEnum needBook) {
        this.needBook = needBook;
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
