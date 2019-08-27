package net.seocoo.ggys.module.order.mapper;

import net.seocoo.ggys.module.order.entity.GrouponOrderDO;

/**
 * 团购订单DAO类
 * @author ZengXiaoLiang
 * @date 2018/5/29 14:44
*/ 
public interface GrouponOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrouponOrderDO record);

    int insertSelective(GrouponOrderDO record);

    GrouponOrderDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrouponOrderDO record);

    int updateByPrimaryKey(GrouponOrderDO record);
}