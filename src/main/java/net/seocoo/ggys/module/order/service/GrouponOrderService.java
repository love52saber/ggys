package net.seocoo.ggys.module.order.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.order.dto.GrouponOrderDTO;
import net.seocoo.ggys.module.order.dto.OrderListDTO;
import net.seocoo.ggys.module.order.entity.GrouponOrderDO;
import net.seocoo.ggys.module.order.form.GrouponOrderForm;
import net.seocoo.ggys.module.order.query.MerchantOrderQuery;
import net.seocoo.ggys.module.user.entity.UserInfoDO;

/**
 * 团购订单Service接口
 *
 * @author ZengXiaoLiang
 * @date 2018/6/7 16:31
 **/
public interface GrouponOrderService {
    /**
     * 团购订单下单
     *
     * @param grouponOrderForm 团购订单form
     * @param userInfo         下单人
     */
    void save(GrouponOrderForm grouponOrderForm, UserInfoDO userInfo);

    /**
     * 根据主键Id查询
     *
     * @param  baseOrderId
     * @return 团购订单实体，如果不存在返回null
     */
    GrouponOrderDTO getDtoByBaseOrderId(int baseOrderId);

    GrouponOrderDO getById(int id);

    PageBean<OrderListDTO> page(MerchantOrderQuery query);

    Boolean updateOrderState(GrouponOrderForm grouponOrderForm);
}
