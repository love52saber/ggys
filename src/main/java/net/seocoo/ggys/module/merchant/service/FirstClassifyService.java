package net.seocoo.ggys.module.merchant.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.FirstClassifyDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 一级分类service接口
 */
public interface FirstClassifyService {
    /**
     * 新增
     * @param firstClassifyDO 实体类
     * @return dao操作结果
     */
     Boolean save(FirstClassifyDO firstClassifyDO);

    /**
     * 删除
     * @param firstClassifyId 主键
     * @return dao操作结果
     */
     Boolean delete(Integer firstClassifyId);

    /**
     * 更新
     * @param firstClassifyDO 实体类
     * @return doa操作结果
     */
     Boolean update(FirstClassifyDO firstClassifyDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
     List<FirstClassifyDO> list(BaseQuery baseQuery);
}
