package net.seocoo.ggys.module.user.service;

import net.seocoo.ggys.module.user.entity.ValidateCodeDO;

import java.util.List;

/**
 * @author wangpan
 * @date 2018/6/9 15:43
 */
public interface ValidateCodeService {
  int deleteByPrimaryKey(Integer id);

  int insert(ValidateCodeDO record);

  int insertSelective(ValidateCodeDO record);

  ValidateCodeDO selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(ValidateCodeDO record);

  int updateByPrimaryKey(ValidateCodeDO record);

  List<ValidateCodeDO> queryValidateCodeListByPhone (ValidateCodeDO record);

}
