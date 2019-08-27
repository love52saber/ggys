package net.seocoo.ggys.module.user.service.impl;

import com.github.pagehelper.PageHelper;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.base.BaseService;
import net.seocoo.ggys.core.base.PageBean;
import net.seocoo.ggys.core.constants.CacheKeyPrefix;
import net.seocoo.ggys.core.constants.UserRoleEnum;
import net.seocoo.ggys.core.constants.YesNoEnum;
import net.seocoo.ggys.core.util.MD5Util;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.module.emchant.service.EmchantRegisterService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.exception.UserInfoException;
import net.seocoo.ggys.module.user.mapper.UserInfoMapper;
import net.seocoo.ggys.module.user.query.UserInfoQuery;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wangpan
 * @date 2018/5/31 11:27
 */
@Service
public class UserInfoServiceImpl extends BaseService implements UserInfoService {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private RedisUtil redisUtil;

  @Autowired
  private EmchantRegisterService emchantRegisterService;

  /**
   * 保存用户信息
   * @param userInfo
   * @return
   */
  @Override
  public int saveUserInfo(UserInfoDO userInfo) {
    /**
     * 校验登陆名是否已存在
     */
    if (!"".equals(userInfo.getLoginName()) && userInfo.getLoginName()!=null){
      UserInfoDO user = new UserInfoDO();
      user.setLoginName(userInfo.getLoginName());
      List<UserInfoDO> userInfoDOList = userInfoMapper.queryUserInfoList(user);
      if (userInfoDOList.size()>0){
        throw new UserInfoException("登录名已存在",RequestCode.forbid_error);
      }
    }
    String uuid = StringEx.newUUID();
    userInfo.setUuid(uuid);
    if(userInfo.getUserRole()==null){
      userInfo.setUserRole(UserRoleEnum.NORMAL);
    }
    userInfo.setCreateDate(new Date());
    userInfo.setUpdateDate(new Date());
    userInfo.setCanDeleted(YesNoEnum.N);
    //密码进行MD5加密
    if(userInfo.getPassword()!=null && !"".equals(userInfo.getPassword())) {
      String password = MD5Util.MD5Encode(userInfo.getPassword(),"utf-8");
      userInfo.setPassword(password);
    }
    userInfoMapper.insert(userInfo);
    //注册环信 即时通信
    emchantRegisterService.registerForSingle(userInfo);
    return userInfo.getId();
  }

  @Override
  public boolean updateUserInfo(UserInfoDO userInfoDO) {
    return userInfoMapper.updateByPrimaryKeySelective(userInfoDO) < 1 ? false : true;
  }

  @Override
  public PageBean<UserInfoDO> listByPageQuery(UserInfoQuery query) {
    PageHelper.startPage(query.getPageNum(), query.getPageSize());
    List<UserInfoDO> userInfoDOList = userInfoMapper.listByPageQuery(query);
    return new PageBean<>(query.getPageNum(), query.getPageSize(), this.countByQuery(query), userInfoDOList);
  }

  @Override
  public Integer countByQuery(UserInfoQuery query) {
    return userInfoMapper.countByQuery(query);
  }

  @Override
  public List<UserInfoDO> queryUserInfoList(UserInfoDO userInfoDO) {
    return userInfoMapper.queryUserInfoList(userInfoDO);
  }

  @Override
  public UserInfoDO getUserInfoById(int id) {
    UserInfoDO userInfoDO = (UserInfoDO) this.redisUtil.get(CacheKeyPrefix.USER_INFO_ID + id);
    if(userInfoDO == null) {
      userInfoDO = userInfoMapper.selectByPrimaryKey(id);
      if(userInfoDO != null) {
        this.redisUtil.set(CacheKeyPrefix.USER_INFO_ID + id, userInfoDO, 1L, TimeUnit.DAYS);
      }
    }
    return userInfoDO;
  }

  @Override
  public boolean deleteUserInfo(int id) {
    return userInfoMapper.deleteByPrimaryKey(id) < 1 ? false : true;
  }

  @Override
  public void deleteById(int id) {
    UserInfoDO userInfoDO = this.getUserInfoById(id);
    if (userInfoDO == null) {
      throw new UserInfoException("ID=" + id + "的用户不存在", RequestCode.Method_Not_Allowed);
    }
    userInfoDO.setCanDeleted(YesNoEnum.Y);
    userInfoDO.setUpdateDate(new Date());
    userInfoMapper.updateByPrimaryKey(userInfoDO);
  }

  @Override
  public List<UserInfoDO> queryUserInfoListByUserIdList(List userIdList) {
    return this.userInfoMapper.queryUserInfoListByUserIdList(userIdList);
  }

  /**
   * 查询用户信息
   *
   * @param userInfoDO
   * @return
   */
  @Override
  public UserInfoDO queryUserInfo(UserInfoDO userInfoDO) {
    return this.userInfoMapper.queryUserInfo(userInfoDO);
  }
}
