package net.seocoo.ggys.module.user.service.impl;

import net.seocoo.ggys.module.user.entity.ValidateCodeDO;
import net.seocoo.ggys.module.user.mapper.ValidateCodeMapper;
import net.seocoo.ggys.module.user.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangpan
 * @date 2018/6/9 15:44
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
  @Autowired
  private ValidateCodeMapper validateCodeMapper;
  @Override
  public int deleteByPrimaryKey(Integer id) {
    return validateCodeMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(ValidateCodeDO record) {
    return validateCodeMapper.insert(record);
  }

  @Override
  public int insertSelective(ValidateCodeDO record) {
    return validateCodeMapper.insertSelective(record);
  }

  @Override
  public ValidateCodeDO selectByPrimaryKey(Integer id) {
    return validateCodeMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(ValidateCodeDO record) {
    return validateCodeMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(ValidateCodeDO record) {
    return validateCodeMapper.updateByPrimaryKey(record);
  }

  @Override
  public List<ValidateCodeDO> queryValidateCodeListByPhone(ValidateCodeDO record) {
    return validateCodeMapper.queryValidateCodeListByPhone (record);
  }
}
