package net.seocoo.ggys.module.groupon.query;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.seocoo.ggys.core.base.BaseQuery;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 11:09
 * @Email xieheng91@163.com
 * @Desc 团购商品查询
 */
@ApiModel(value = "团购商品查询")
public class MerchantGrouponGoodsQuery extends BaseQuery {
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品id")
    private Integer merchantBaseGoodsId;

    /**
     * 商户id
     */
    @ApiModelProperty(value = "商户id")
    private Integer merchantId;


    public Integer getMerchantBaseGoodsId() {
        return merchantBaseGoodsId;
    }

    public void setMerchantBaseGoodsId(Integer merchantBaseGoodsId) {
        this.merchantBaseGoodsId = merchantBaseGoodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}
