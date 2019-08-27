package net.seocoo.ggys.module.user.service.impl;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.user.entity.UserAddressDO;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.exception.UserAddressException;
import net.seocoo.ggys.module.user.exception.UserInfoException;
import net.seocoo.ggys.module.user.mapper.UserAddressMapper;
import net.seocoo.ggys.module.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wangpan
 * @date 2018/6/7 16:24
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

  @Autowired
  private UserAddressMapper userAddressMapper;

  @Override
  public boolean deleteByPrimaryKey(Integer id) {
    return userAddressMapper.deleteByPrimaryKey(id) <1 ? false: true;
  }

  @Override
  public int saveUserAddress(UserAddressDO record) {
    //保存时赋值
    record.setCanDeleted(YesNoEnum.N);
    record.setCreateDate(new Date());
    record.setUpdateDate(new Date());
    record.setUuid(StringEx.newUUID());
    userAddressMapper.insert(record);
    return record.getId();
  }

  @Override
  public int insertSelective(UserAddressDO record) {
    userAddressMapper.insertSelective(record);
    return record.getId();
  }

  @Override
  public UserAddressDO selectByPrimaryKey(Integer id) {
    return userAddressMapper.selectByPrimaryKey(id);
  }

  @Override
  public boolean updateByPrimaryKeySelective(UserAddressDO record) {
    return userAddressMapper.updateByPrimaryKeySelective(record) < 1 ? false : true;
  }

  @Override
  public boolean updateByPrimaryKey(UserAddressDO record) {
    return userAddressMapper.updateByPrimaryKey(record) < 1 ? false : true;
  }

  /**
   * 删除 假删除
   *
   * @param id
   */
  @Override
  public void deleteById(int id) {
    UserAddressDO userAddress = this.selectByPrimaryKey(id);
    if (userAddress == null) {
      throw new UserAddressException("ID=" + id + "的记录不存在", RequestCode.Method_Not_Allowed);
    }
    userAddress.setCanDeleted(YesNoEnum.Y);
    userAddress.setUpdateDate(new Date());
    userAddressMapper.updateByPrimaryKey(userAddress);
  }

  /**
   * 根据用户的id查询他的收货地址列表
   * @param userId
   * @return
   */
  @Override
  public List<UserAddressDO> queryAddressListByUserId(int userId) {
    return userAddressMapper.queryAddressListByUserId(userId);
  }

  /**
   * 根据userid更新为非默认地址
   *
   * @param record
   * @return
   */
  @Override
  public boolean updateNotDefaultByUserId(UserAddressDO record) {
    record.setUpdateDate(new Date());
    record.setCanDefaultAddress(YesNoEnum.N);
    return userAddressMapper.updateNotDefaultByUserId(record) <1  ? false : true;
  }
}
