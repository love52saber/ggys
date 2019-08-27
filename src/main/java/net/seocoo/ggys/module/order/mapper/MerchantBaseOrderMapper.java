package net.seocoo.ggys.module.order.mapper;

import net.seocoo.ggys.module.order.entity.MerchantBaseOrderDO;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;

import java.util.List;

/**
 * 订单DAO基类
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:51
 */
public interface MerchantBaseOrderMapper {
    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入对象
     *
     * @param record 实体
     * @return 主键
     */
    int insert(MerchantBaseOrderDO record);

    /**
     * 插入不为空的字段
     *
     * @param record 实体
     * @return 受影响的行数
     */
    int insertSelective(MerchantBaseOrderDO record);

    /**
     * 根据主键查询
     *
     * @param id 主键Id
     * @return 实体
     */
    MerchantBaseOrderDO selectByPrimaryKey(Integer id);

    /**
     * 更新不为空的字段
     *
     * @param record 实体
     * @return 受响应的行数
     */
    int updateByPrimaryKeySelective(MerchantBaseOrderDO record);

    /**
     * 更新实体
     *
     * @param record 实体
     * @return 受影响的行数
     */
    int updateByPrimaryKey(MerchantBaseOrderDO record);

    /*自定义mapper*/

    /**
     * 逻辑删除
     *
     * @param orderId 主键
     * @return
     */
    int delete(Integer orderId);


    /**
     * 查询数量
     *
     * @param query
     * @return
     */
    Integer count(MerchantOrderQuery query);

    /**
     * 根据query查询列表
     *
     * @param query MerchantOrderQuery
     * @return 订单集合
     */
    List<MerchantBaseOrderDO> listByQuery(MerchantOrderQuery query);


}