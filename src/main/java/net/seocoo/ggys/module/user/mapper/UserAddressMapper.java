package net.seocoo.ggys.module.user.mapper;

import net.seocoo.ggys.module.user.entity.UserAddressDO;

import java.util.List;

public interface UserAddressMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(UserAddressDO record);

  int insertSelective(UserAddressDO record);

  UserAddressDO selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(UserAddressDO record);

  int updateByPrimaryKey(UserAddressDO record);

  List<UserAddressDO> queryAddressListByUserId(int userId);

  int updateNotDefaultByUserId(UserAddressDO record);
}