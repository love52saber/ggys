package net.seocoo.ggys.module.user.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @author wangpan
 * @date 2018/6/7 16:52
 */
public class UserAddressException extends AppException {
  public UserAddressException(String msg, int code) {
    super(msg, code);
  }
}
