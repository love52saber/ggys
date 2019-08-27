package net.seocoo.ggys.module.log.mapper;

import net.seocoo.ggys.module.log.entity.OperateLogDO;

public interface OperateLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperateLogDO record);

    int insertSelective(OperateLogDO record);

    OperateLogDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperateLogDO record);

    int updateByPrimaryKey(OperateLogDO record);
}