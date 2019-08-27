package net.seocoo.ggys.module.order.service;

import net.seocoo.ggys.module.order.entity.MerchantOrderGoodsDO;

import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/8 8:48
 **/
public interface MerchantOrderGoodsService {

  /**
   * 新增
   * @param merchantOrderGoods 订单商品中间表
   * @return 新增成功返回true，返回返回false
   */
  boolean save(MerchantOrderGoodsDO merchantOrderGoods);

  /**
   * 编辑
   * @param merchantOrderGoods 订单商品中间表
   * @return 更新成功返回true，否则返回false
   */
  boolean update(MerchantOrderGoodsDO merchantOrderGoods);

  /**
   * 查询集合
   * @param merchantOrderGoods 订单商品中间表
   * @return 集合
   */
  List<MerchantOrderGoodsDO> listByQuery(MerchantOrderGoodsDO merchantOrderGoods);

  /**
   * 查询总数
   * @param merchantOrderGoods 订单商品中间表
   * @return  总数
   */
  Integer countByQuery(MerchantOrderGoodsDO merchantOrderGoods);

  /**
   * 查询订单下的所有商品集合
   * @param orderId 订单Id
   * @return 订单商品集合
   */
  List<MerchantOrderGoodsDO> listByOrderId(int orderId);
}
