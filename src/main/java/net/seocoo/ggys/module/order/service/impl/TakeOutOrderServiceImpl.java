package net.seocoo.ggys.module.order.service.impl;

import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.order.entity.TakeOutOrderDO;
import net.seocoo.ggys.module.order.mapper.TakeOutOrderMapper;
import net.seocoo.ggys.module.order.service.TakeOutOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 外卖订单Service
 * @author ZengXiaoLiang
 * @date 2018/6/9 16:22
 **/
@Service
public class TakeOutOrderServiceImpl extends BaseService implements TakeOutOrderService{

  @Autowired
  private TakeOutOrderMapper takeOutOrderMapper;

  @Override
  public TakeOutOrderDO getById(int id) {
    return this.takeOutOrderMapper.selectByPrimaryKey(id);
  }
}
