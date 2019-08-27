package net.seocoo.ggys.module.merchant.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.module.merchant.entity.MerchantSecondClassifyDO;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 商户和分类中间表service接口
 */
public interface MerchantSecondClassifyService {
    /**
     * 新增
     * @param merchantSecondClassifyDO 实体类
     * @return dao操作结果
     */
    public Boolean save(MerchantSecondClassifyDO merchantSecondClassifyDO);

    /**
     * 删除
     * @param merchantSecondClassifyId 主键
     * @return dao操作结果
     */
    public Boolean delete(Integer merchantSecondClassifyId);

    /**
     * 删除
     * @param merchantId 主键
     * @return dao操作结果
     */
    public Boolean deleteMerchantId(Integer merchantId);

    /**
     * 更新
     * @param merchantSecondClassifyDO 实体类
     * @return doa操作结果
     */
    public Boolean update(MerchantSecondClassifyDO merchantSecondClassifyDO);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    public List<MerchantSecondClassifyDO> list(BaseQuery baseQuery);

    /**
     * 批量插入
     * @param list
     * @return
     */
    public Boolean insertBatch(List<MerchantSecondClassifyDO> list);

    /**
     * 根据商家Id与一级分类Id查询
     * @param merchantId
     * @param firstClassifyId
     * @return
     */
    List<MerchantSecondClassifyDO> listByMerchantIdFirstId(Integer merchantId, Integer firstClassifyId);
}
