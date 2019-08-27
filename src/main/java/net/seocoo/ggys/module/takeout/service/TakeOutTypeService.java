package net.seocoo.ggys.module.takeout.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutRuleDO;
import net.seocoo.ggys.module.takeout.entity.MerchantTakeOutTypeDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 外卖规则service接口
 */
public interface TakeOutTypeService {


    /**
     * 新增
     * @param merchantTakeOutTypeDO 实体类
     * @return dao操作结果
     */
    Boolean save(MerchantTakeOutTypeDO merchantTakeOutTypeDO);

    /**
     * 删除分类前需要判断该分类下是否有其他外卖商品存在
     * @param merchantTakeOutTypeId 主键
     * @return dao操作结果
     */
    Boolean delete(Integer merchantTakeOutTypeId);

    /**
     * 更新
     * @param merchantTakeOutTypeDO 实体类
     * @return doa操作结果
     */
    Boolean update(MerchantTakeOutTypeDO merchantTakeOutTypeDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    List<MerchantTakeOutTypeDO> list(BaseQuery baseQuery);
}
