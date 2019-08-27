package net.seocoo.ggys.module.order.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.order.constants.OrderStateEnum;
import net.seocoo.ggys.module.order.dto.IndexDTO;
import net.seocoo.ggys.module.order.dto.OrderListDTO;
import net.seocoo.ggys.module.order.entity.MerchantBaseOrderDO;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/8 16:10
 **/
public interface MerchantBaseOrderService {
  /**
   * @param query
   * @return
   */
  PageBean<OrderListDTO> listByQuery(MerchantOrderQuery query);

  /**
   * 提交订单保存
   * @param merchantBaseOrderDO
   * @return
   */
  Boolean save(MerchantBaseOrderDO merchantBaseOrderDO);

  /**
   * 修改订单状态
   * @param id
   * @param orderStateEnum
   * @return
   */
  Boolean updateOrderState(Integer id,OrderStateEnum orderStateEnum);

  /**
   * 旺铺帮h5首页订单信息
   * @param merchantId
   * @return
   */
  IndexDTO index(Integer merchantId);

  MerchantBaseOrderDO get(Integer id);


}
