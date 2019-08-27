package net.seocoo.ggys.module.evaluate.mapper;

import net.seocoo.ggys.module.evaluate.entity.OrderEvaluateDO;
import net.seocoo.ggys.module.evaluate.query.OrderEvaluateQuery;

import java.util.List;

public interface OrderEvaluateMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增订单评价
     * @param record
     * @return
     */
    int insert(OrderEvaluateDO record);

    /**
     * 新增订单评价指定属性
     * @param record
     * @return
     */
    int insertSelective(OrderEvaluateDO record);

    /**
     * 查询订单评价
     * @param id
     * @return
     */
    OrderEvaluateDO selectByPrimaryKey(Integer id);

    /**
     * 更新订单评价指定属性
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(OrderEvaluateDO record);

    /**
     * 更新订单评价
     * @param record
     * @return
     */
    int updateByPrimaryKey(OrderEvaluateDO record);

    /**
     * 分页查询订单评价列表
     * @param query
     * @return
     */
    List<OrderEvaluateDO> listByPageQuery(OrderEvaluateQuery query);

    /**
     * 总数
     * @param query
     * @return
     */
    Integer countByQuery(OrderEvaluateQuery query);
}