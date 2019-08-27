package net.seocoo.ggys.module.takeout.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutRuleDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 外卖规则service接口
 */
public interface TakeOutRuleService {


    /**
     * 新增
     * @param merchantTakeOutRuleDO 实体类
     * @return dao操作结果
     */
    Boolean save(MerchantTakeOutRuleDO merchantTakeOutRuleDO);

    /**
     * 删除
     * @param merchantGrouponTemplateId 主键
     * @return dao操作结果
     */
    Boolean delete(Integer merchantGrouponTemplateId);

    /**
     * 更新
     * @param merchantTakeOutRuleDO 实体类
     * @return doa操作结果
     */
    Boolean update(MerchantTakeOutRuleDO merchantTakeOutRuleDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    List<MerchantTakeOutRuleDO> list(BaseQuery baseQuery);
}
