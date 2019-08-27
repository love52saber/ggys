package net.seocoo.ggys.module.merchant.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @Author xieheng
 * @Data 2018/6/7 0007 9:28
 * @Email xieheng91@163.com
 * @Desc 二级分类表单
 */
@ApiModel(value = "二级分类表单")
public class SecondClassifyForm implements Serializable {

    /**
     * 一级分类id
     */
    @ApiModelProperty(value = "一级分类主键")
    private Integer firstClassifyId;


    @ApiModelProperty(value = "二级分类主键")
    private Integer id;

    /**
     * 二级分类名称
     */
    @Length(max = 5,message = "长度不能超过5个字符")
    @ApiModelProperty(value = "二级分类名称")
    private String name;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String imgUrl;


    /**
     * 排序号
     */
    @ApiModelProperty(value = "排序号")
    private Integer sortNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstClassifyId() {
        return firstClassifyId;
    }

    public void setFirstClassifyId(Integer firstClassifyId) {
        this.firstClassifyId = firstClassifyId;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
