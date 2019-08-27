package net.seocoo.ggys.module.goods.service;

import net.seocoo.ggys.core.base.BaseQuery;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDO;
import net.seocoo.ggys.module.goods.entity.MerchantBaseGoodsDTO;
import net.seocoo.ggys.module.goods.form.GoodsAuditForm;
import net.seocoo.ggys.module.goods.query.MerchantBaseGoodsQuery;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/6/4 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 商品基本信息service接口
 */
public interface MerchantBaseGoodsService {
    /**
     * 新增
     * @param merchantBaseGoodsDO 实体类
     * @return dao操作结果
     */
    Boolean save(MerchantBaseGoodsDO merchantBaseGoodsDO);

    /**
     * 删除
     * @param merchantBaseGoodsId 主键
     * @return dao操作结果
     */
    Boolean delete(Integer merchantBaseGoodsId);

    /**
     * 更新
     * @param merchantBaseGoodsDO 实体类
     * @return doa操作结果
     */
    Boolean update(MerchantBaseGoodsDO merchantBaseGoodsDO);

    /**
     * 按条件查询返回list结果
     * @param query
     * @return 查询结果list
     */
    List<MerchantBaseGoodsDTO> list(MerchantBaseGoodsQuery query);

    /**
     * 分页查询
     * @param baseQuery
     * @return
     */
    PageBean<MerchantBaseGoodsDTO> page(MerchantBaseGoodsQuery baseQuery);

    /**
     * 获取单条记录
     * @param baseQuery
     * @return
     */
    MerchantBaseGoodsDO get(BaseQuery baseQuery);

    /**
     * 审核
     * @param goodsAuditForm
     * @return
     */
    Boolean auditGoods(GoodsAuditForm goodsAuditForm);

    MerchantBaseGoodsDTO get(Integer id);


    Integer count(MerchantBaseGoodsQuery merchantBaseGoodsQuery);

    BigDecimal getMinimumPriceByMerchantId(Integer merchantId);
}
