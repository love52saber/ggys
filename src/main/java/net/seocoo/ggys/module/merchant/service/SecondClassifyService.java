package net.seocoo.ggys.module.merchant.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.SecondClassifyDO;
import net.seocoo.ggys.module.merchant.query.SecondClassifyQuery;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 14:06
 * @Email xieheng91@163.com
 * @Desc 二级分类service接口
 */
public interface SecondClassifyService {
    /**
     * 新增
     * @param secondClassifyDO 实体类
     * @return dao操作结果
     */
    public Boolean save(SecondClassifyDO secondClassifyDO);

    /**
     * 删除
     * @param secondClassifyId 主键
     * @return dao操作结果
     */
    public Boolean delete(Integer secondClassifyId);

    /**
     * 更新
     * @param secondClassifyDO 实体类
     * @return doa操作结果
     */
    public Boolean update(SecondClassifyDO secondClassifyDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    public List<SecondClassifyDO> list(SecondClassifyQuery baseQuery);

    /**
     * 查询一级分类下二级分类
     * @param firstClassifyId
     * @return
     */
    public List<SecondClassifyDO> list(Integer firstClassifyId);


    SecondClassifyDO getById(Integer id);
}
