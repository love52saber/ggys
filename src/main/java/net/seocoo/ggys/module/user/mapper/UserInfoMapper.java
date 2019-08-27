package net.seocoo.ggys.module.user.mapper;

import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.query.UserInfoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(UserInfoDO record);

  int insertSelective(UserInfoDO record);

  UserInfoDO selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(UserInfoDO record);

  int updateByPrimaryKey(UserInfoDO record);

  List<UserInfoDO> queryUserInfoList(UserInfoDO userInfoDO);

  List<UserInfoDO> listByPageQuery(UserInfoQuery userInfoQuery);

  int countByQuery(UserInfoQuery query);

  /**
   * 根据userId集合查询用户信息集合
   * @param userIdList
   * @return
   */
  List<UserInfoDO> queryUserInfoListByUserIdList(@Param("userIdList") List<Integer> userIdList);

  /**
   * 查询用户信息
   *
   * @param userInfoDO
   * @return
   */
  UserInfoDO queryUserInfo(UserInfoDO userInfoDO);
}