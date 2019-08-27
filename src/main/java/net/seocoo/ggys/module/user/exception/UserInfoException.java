package net.seocoo.ggys.module.user.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @author wangpan
 * @date 2018/6/3 21:47
 */
public class UserInfoException extends AppException {
  public UserInfoException(String msg, int code) {
    super(msg, code);
  }
}
