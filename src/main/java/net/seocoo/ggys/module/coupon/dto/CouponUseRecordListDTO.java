package net.seocoo.ggys.module.coupon.dto;

import java.util.Date;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/12 11:25
 **/
public class CouponUseRecordListDTO {
  private Integer id;
  private String nickname;
  private Date getDate;
  private String state;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Date getGetDate() {
    return getDate;
  }

  public void setGetDate(Date getDate) {
    this.getDate = getDate;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
