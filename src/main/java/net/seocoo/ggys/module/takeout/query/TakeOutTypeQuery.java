package net.seocoo.ggys.module.takeout.query;

import com.sun.xml.internal.rngom.parse.host.Base;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 15:29
 * @Email xieheng91@163.com
 * @Desc 外卖分类查询
 */
public class TakeOutTypeQuery extends Base {

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
