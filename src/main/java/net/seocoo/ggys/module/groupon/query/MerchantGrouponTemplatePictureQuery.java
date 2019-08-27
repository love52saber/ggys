package net.seocoo.ggys.module.groupon.query;

import net.seocoo.ggys.core.base.BaseQuery;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 11:24
 * @Email xieheng91@163.com
 * @Desc 团购模板图片查询
 */
public class MerchantGrouponTemplatePictureQuery extends BaseQuery {

    /**
     * 团购模板id
     */
    private Integer merchantGrouponTemplateId;

    public Integer getMerchantGrouponTemplateId() {
        return merchantGrouponTemplateId;
    }

    public void setMerchantGrouponTemplateId(Integer merchantGrouponTemplateId) {
        this.merchantGrouponTemplateId = merchantGrouponTemplateId;
    }
}
