package net.seocoo.ggys.module.user.service;

import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.query.UserInfoQuery;

import java.util.List;

/**
 * @author wangpan
 * @date 2018/5/31 11:25
 */
public interface UserInfoService {
  /**
   * 保存用户信息
   * 返回保存的记录的id
   * @param userInfo
   * @return
   */
  int saveUserInfo(UserInfoDO userInfo);

  /**
   * 更新用户对象
   *
   * @param userInfoDO
   * @return
   */
  boolean updateUserInfo(UserInfoDO userInfoDO);

  /**
   * 根据id查询用户对象
   *
   * @param id
   * @return
   */
  UserInfoDO getUserInfoById(int id);


  /**
   * 删除用户
   *
   * @param id
   * @return
   */
  boolean deleteUserInfo(int id);

  /**
   * 查询列表
   *
   * @param userInfoDO
   * @return
   */
  List<UserInfoDO> queryUserInfoList(UserInfoDO userInfoDO);

  /**
   * 分页查询用户对象的集合
   *
   * @param userInfoQuery
   * @return
   */
  PageBean<UserInfoDO> listByPageQuery(UserInfoQuery userInfoQuery);


  /**
   * 查询总数
   *
   * @param query
   * @return
   */
  Integer countByQuery(UserInfoQuery query);

  /**
   * 删除 假删除
   *
   * @param id
   */
  void deleteById(int id);

  /**
   * 根据userId集合查询用户信息集合
   * @param userIdList
   * @return
   */
  List<UserInfoDO> queryUserInfoListByUserIdList(List userIdList);

  /**
   * 查询用户信息
   *
   * @param userInfoDO
   * @return
   */
  UserInfoDO queryUserInfo(UserInfoDO userInfoDO);
}
