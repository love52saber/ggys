package net.seocoo.ggys.module.evaluate.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.evaluate.dto.EvaluateDTO;
import net.seocoo.ggys.module.evaluate.dto.OrderEvaluateDTO;
import net.seocoo.ggys.module.evaluate.entity.OrderEvaluateDO;
import net.seocoo.ggys.module.evaluate.query.OrderEvaluateQuery;

/**
 * @author PanChengHao
 * @date 2018/6/13 18:01
 */
public interface OrderEvaluateService {

  /**
   * 新增订单评价
   * @param orderEvaluateDO
   */
  void saveOrderEvaluate(OrderEvaluateDO orderEvaluateDO);

  /**
   * 更新订单评价指定属性
   * @param orderEvaluateDO
   */
  void updateOrderEvaluateSelective(OrderEvaluateDO orderEvaluateDO);

  /**
   * 根据id查询订单评价
   * @param id
   * @return
   */
  OrderEvaluateDTO getOrderEvaluateById(int id);

  /**
   * 订单评价分页查询
   * @param query
   * @return
   */
  PageBean<EvaluateDTO> listByPageQuery(OrderEvaluateQuery query);

  /**
   * 查询总数
   * @param query
   * @return
   */
  Integer countByQuery(OrderEvaluateQuery query);


}
