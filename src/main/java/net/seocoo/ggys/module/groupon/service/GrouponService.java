package net.seocoo.ggys.module.groupon.service;


import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.groupon.entity.MerchantGrouponGoodsDTO;
import net.seocoo.ggys.module.groupon.form.GrouponGoodsForm;
import net.seocoo.ggys.module.groupon.query.MerchantGrouponGoodsQuery;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 10:10
 * @Email xieheng91@163.com
 * @Desc 团购模板service接口
 */
public interface GrouponService {

    /**
     * 新增
     * @param grouponGoodsForm
     * @return dao操作结果
     */
    Boolean save(GrouponGoodsForm grouponGoodsForm,Integer merchantUserId);

    /**
     * 删除
     * @param goodsId 主键
     * @return dao操作结果
     */
    Boolean delete(Integer goodsId);

    /**
     * 更新
     * @param grouponGoodsForm
     * @return doa操作结果
     */
    Boolean update(GrouponGoodsForm  grouponGoodsForm);

    /**
     * 按条件查询返回list结果
     * @param baseQuery
     * @return 查询结果list
     */
    List<MerchantGrouponGoodsDTO> list(MerchantGrouponGoodsQuery baseQuery,Integer merchantUserId);

    /**
     * 分页查询
     * @param baseQuery
     * @return
     */
    PageBean<MerchantGrouponGoodsDTO> page(MerchantGrouponGoodsQuery baseQuery,Integer merchantUserId);

    /**
     * 查询单个团购商品模板信息
     * @param id
     * @return
     */
    MerchantGrouponGoodsDTO get(Integer id);
}
