package net.seocoo.ggys.module.user.service;

import net.seocoo.ggys.module.user.entity.UserAddressDO;

import java.util.List;

/**
 * @author wangpan
 * @date 2018/6/7 16:21
 */
public interface UserAddressService {
  boolean deleteByPrimaryKey(Integer id);

  /**
   * 返回保存的记录的id
   * @param record
   * @return
   */
  int saveUserAddress(UserAddressDO record);
  /**
   * 返回保存的记录的id
   * @param record
   * @return
   */
  int insertSelective(UserAddressDO record);

  UserAddressDO selectByPrimaryKey(Integer id);

  boolean updateByPrimaryKeySelective(UserAddressDO record);

  boolean updateByPrimaryKey(UserAddressDO record);

  /**
   * 删除 假删除
   *
   * @param id
   */
  void deleteById(int id);

  /**
   * 根据用户的id查询他的收货地址列表
   * @param userId
   * @return
   */
  List<UserAddressDO> queryAddressListByUserId (int userId);

  /**
   * 根据userid更新 是否是默认地址
   * @param record
   * @return
   */
  boolean updateNotDefaultByUserId(UserAddressDO record);

}
