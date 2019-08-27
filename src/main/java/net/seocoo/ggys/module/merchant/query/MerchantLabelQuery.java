package net.seocoo.ggys.module.merchant.query;

import net.seocoo.ggys.core.base.BaseQuery;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 9:20
 * @Email xieheng91@163.com
 * @Desc 商户标签查询
 */
public class MerchantLabelQuery extends BaseQuery {

    /**
     * 标签名称
     */
    private String name;

    private Integer merchantId;

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

}
