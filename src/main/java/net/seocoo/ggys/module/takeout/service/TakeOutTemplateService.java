package net.seocoo.ggys.module.takeout.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTemplateDO;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTypeDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 外卖商品模板service
 */
public interface TakeOutTemplateService {


    /**
     * 新增
     * @param merchantTakeOutTemplateDO 实体类
     * @return dao操作结果
     */
    Boolean save(MerchantTakeOutTemplateDO merchantTakeOutTemplateDO);

    /**
     * 删除
     * @param merchantTakeOutTemplateId 主键
     * @return dao操作结果
     */
    Boolean delete(Integer merchantTakeOutTemplateId);

    /**
     * 更新
     * @param merchantTakeOutTemplateDO 实体类
     * @return doa操作结果
     */
    Boolean update(MerchantTakeOutTemplateDO merchantTakeOutTemplateDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    List<MerchantTakeOutTemplateDO> list(BaseQuery baseQuery);

    /**
     * 通过外卖分类id，查询此分类下是否存在外卖商品
     * @param merchantTakeOutTypeId
     * @return
     */
    Boolean existByTakeOutTypeId(Integer merchantTakeOutTypeId);
}
