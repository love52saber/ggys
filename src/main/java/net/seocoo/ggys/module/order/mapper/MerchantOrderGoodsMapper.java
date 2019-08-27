package net.seocoo.ggys.module.order.mapper;

import net.seocoo.ggys.module.order.entity.MerchantOrderGoodsDO;

import java.util.List;

/**
 * 订单商品中间表DAO类
 *
 * @author ZengXiaoLiang
 * @date 2018/5/29 15:02
 */
public interface MerchantOrderGoodsMapper {
  /**
   * 根据主键删除
   * @param id 主键
   * @return 受影响的行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * 插入对象
   * @param record 实体
   * @return 主键
   */
  int insert(MerchantOrderGoodsDO record);

  /**
   * 插入对象
   * @param record 实体
   * @return 主键
   */
  int insertSelective(MerchantOrderGoodsDO record);

  /**
   * 根据主键查询
   * @param id 主键
   * @return 实体对象
   */
  MerchantOrderGoodsDO selectByPrimaryKey(Integer id);

  /**
   * 更新对象
   * @param record 实体
   * @return 受影响的行数
   */
  int updateByPrimaryKeySelective(MerchantOrderGoodsDO record);

  /**
   * 更新对象
   * @param record 实体
   * @return 受影响的行数
   */
  int updateByPrimaryKey(MerchantOrderGoodsDO record);

  /**
   * 查询集合
   * @param merchantOrderGoods 商品订单对象
   * @return 集合
   */
  List<MerchantOrderGoodsDO> listByQuery(MerchantOrderGoodsDO merchantOrderGoods);

  /**
   * 查询总数
   * @param merchantOrderGoods 商品订单对象
   * @return 总数
   */
  Integer countByQuery(MerchantOrderGoodsDO merchantOrderGoods);
}