package net.seocoo.ggys.module.takeout.query;

import net.seocoo.ggys.core.base.BaseQuery;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 15:27
 * @Email xieheng91@163.com
 * @Desc 外卖规则查询
 */
public class TakeOutRuleQuery extends BaseQuery {

    /**
     * 商户id
     */
    private Integer merchantId;

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}
