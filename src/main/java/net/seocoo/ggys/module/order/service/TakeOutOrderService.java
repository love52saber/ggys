package net.seocoo.ggys.module.order.service;

import net.seocoo.ggys.module.order.entity.TakeOutOrderDO;

/**
 * 外卖订单Service
 * @author ZengXiaoLiang
 * @date 2018/6/9 16:20
 **/
public interface TakeOutOrderService {
  /**
   * 根据Id查询
   * @param id 根据Id查询
   * @return 外卖订单实体，不存在返回null
   */
  TakeOutOrderDO getById(int id);
}
