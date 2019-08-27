package net.seocoo.ggys.module.order.service.impl;

import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.module.order.entity.MerchantOrderGoodsDO;
import net.seocoo.ggys.module.order.mapper.MerchantOrderGoodsMapper;
import net.seocoo.ggys.module.order.service.MerchantOrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/8 8:56
 **/
@Service
public class MerchantOrderGoodsServiceImpl extends BaseService implements MerchantOrderGoodsService {

  @Autowired
  private MerchantOrderGoodsMapper merchantOrderGoodsMapper;

  @Override
  public boolean save(MerchantOrderGoodsDO merchantOrderGoods) {
    return merchantOrderGoodsMapper.insertSelective(merchantOrderGoods)>0?true:false;
  }

  @Override
  public boolean update(MerchantOrderGoodsDO merchantOrderGoods) {
    return merchantOrderGoodsMapper.updateByPrimaryKeySelective(merchantOrderGoods)>0?true:false;
  }

  @Override
  public List<MerchantOrderGoodsDO> listByQuery(MerchantOrderGoodsDO merchantOrderGoods) {
    return this.merchantOrderGoodsMapper.listByQuery(merchantOrderGoods);
  }

  @Override
  public Integer countByQuery(MerchantOrderGoodsDO merchantOrderGoods) {
    return this.merchantOrderGoodsMapper.countByQuery(merchantOrderGoods);
  }

  @Override
  public List<MerchantOrderGoodsDO> listByOrderId(int orderId) {
    MerchantOrderGoodsDO record = new MerchantOrderGoodsDO();
    record.setOrderId(orderId);
    return this.listByQuery(record);
  }
}
