package net.seocoo.ggys.module.user.mapper;

import net.seocoo.ggys.module.user.entity.ValidateCodeDO;

import java.util.List;

public interface ValidateCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ValidateCodeDO record);

    int insertSelective(ValidateCodeDO record);

    ValidateCodeDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ValidateCodeDO record);

    int updateByPrimaryKey(ValidateCodeDO record);

    List<ValidateCodeDO> queryValidateCodeListByPhone (ValidateCodeDO record);
}