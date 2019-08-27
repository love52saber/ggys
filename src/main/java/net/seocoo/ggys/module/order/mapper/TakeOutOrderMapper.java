package net.seocoo.ggys.module.order.mapper;

import net.seocoo.ggys.module.order.entity.TakeOutOrderDO;

/**
 * 外卖订单DAO
 * @author ZengXiaoLiang
 * @date 2018/5/29 15:05
*/ 
public interface TakeOutOrderMapper {
  /**
   * 根据主键删除
   * @param id 主键
   * @return 受影响的行数
   */
  int deleteByPrimaryKey(Integer id);

  /**
   *
   * @param record
   * @return
   */
  int insert(TakeOutOrderDO record);

  int insertSelective(TakeOutOrderDO record);

  TakeOutOrderDO selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(TakeOutOrderDO record);

  int updateByPrimaryKey(TakeOutOrderDO record);
}