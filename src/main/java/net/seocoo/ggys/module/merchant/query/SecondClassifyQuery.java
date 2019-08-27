package net.seocoo.ggys.module.merchant.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 14:57
 * @Email xieheng91@163.com
 * @Desc 二级分类查询
 */
@ApiModel(value = "二级分类查询条件")
public class SecondClassifyQuery extends BaseQuery {

    @ApiModelProperty(value = "二级分分类名称")
    private String name;

    @ApiModelProperty(value = "一级分类主键id")
    private Integer firstClassifyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFirstClassifyId() {
        return firstClassifyId;
    }

    public void setFirstClassifyId(Integer firstClassifyId) {
        this.firstClassifyId = firstClassifyId;
    }
}
