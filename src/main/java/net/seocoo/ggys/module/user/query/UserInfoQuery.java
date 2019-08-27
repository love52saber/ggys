package net.seocoo.ggys.module.user.query;

import net.seocoo.ggys.core.base.BaseQuery;

import java.util.Date;

/**
 * @author wangpan
 * @date 2018/5/31 17:18
 */
public class UserInfoQuery extends BaseQuery {

  private String nickname;
  private String phone;
  private String fullName;
//  private String canDeleted;
  private String userRole;
  private String openId;
  private String loginName;


  @Override
  public String getUuid() {
    return super.getUuid();
  }

  @Override
  public void setUuid(String uuid) {
    super.setUuid(uuid);
  }

  @Override
  public String getOrderBy() {
    return super.getOrderBy();
  }

  @Override
  public void setOrderBy(String orderBy) {
    super.setOrderBy(orderBy);
  }

  @Override
  public Integer getPageSize() {
    return super.getPageSize();
  }

  @Override
  public void setPageSize(Integer pageSize) {
    super.setPageSize(pageSize);
  }

  @Override
  public Integer getPageNum() {
    return super.getPageNum();
  }

  @Override
  public void setPageNum(Integer pageNum) {
    super.setPageNum(pageNum);
  }

  @Override
  public Date getCreateDate() {
    return super.getCreateDate();
  }

  @Override
  public void setCreateDate(Date createDate) {
    super.setCreateDate(createDate);
  }

  @Override
  public Date getStartDate() {
    return super.getStartDate();
  }

  @Override
  public void setStartDate(Date startDate) {
    super.setStartDate(startDate);
  }

  @Override
  public Date getEndDate() {
    return super.getEndDate();
  }

  @Override
  public void setEndDate(Date endDate) {
    super.setEndDate(endDate);
  }

  @Override
  public Integer getId() {
    return super.getId();
  }

  @Override
  public void setId(Integer id) {
    super.setId(id);
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

//  public String getCanDeleted() {
//    return canDeleted;
//  }
//
//  public void setCanDeleted(String canDeleted) {
//    this.canDeleted = canDeleted;
//  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }
}
