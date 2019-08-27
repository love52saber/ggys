package net.seocoo.ggys.module.takeout.query;

import net.seocoo.ggys.core.base.BaseQuery;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 14:33
 * @Email xieheng91@163.com
 * @Desc 外卖商品模板查询
 */
public class TakeOutTemplateQuery extends BaseQuery {

    /**
     * 商品id
     */
    private Integer merchantBaseGoodsId;
    /**
     * 外卖分类di
     */
    private Integer merchantTakeOutTypeId;

    public Integer getMerchantBaseGoodsId() {
        return merchantBaseGoodsId;
    }

    public void setMerchantBaseGoodsId(Integer merchantBaseGoodsId) {
        this.merchantBaseGoodsId = merchantBaseGoodsId;
    }

    public Integer getMerchantTakeOutTypeId() {
        return merchantTakeOutTypeId;
    }

    public void setMerchantTakeOutTypeId(Integer merchantTakeOutTypeId) {
        this.merchantTakeOutTypeId = merchantTakeOutTypeId;
    }
}
