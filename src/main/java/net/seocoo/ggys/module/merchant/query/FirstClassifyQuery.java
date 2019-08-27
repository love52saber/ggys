package net.seocoo.ggys.module.merchant.query;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.constants.YesNoEnum;

import java.util.Date;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 14:11
 * @Email xieheng91@163.com
 * @Desc 一级分类查询
 */
public class FirstClassifyQuery extends BaseQuery {
    
    /**
     * /一级分类名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
