package net.seocoo.ggys.module.user.dto;

import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.user.entity.UserInfoDO;

/**
 * 商家用户DTO
 * @author ZengXiaoLiang
 * @date 2018/6/13 17:23
 **/
public class MerchantUserDTO {
  private UserInfoDO userInfo;
  private MerchantDO merchant;

  public UserInfoDO getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfoDO userInfo) {
    this.userInfo = userInfo;
  }

  public MerchantDO getMerchant() {
    return merchant;
  }

  public void setMerchant(MerchantDO merchant) {
    this.merchant = merchant;
  }
}
