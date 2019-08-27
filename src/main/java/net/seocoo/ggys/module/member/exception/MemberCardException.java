package net.seocoo.ggys.module.member.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @author PanChengHao
 * @date 2018/6/1 11:48
 */
public class MemberCardException extends AppException {
  public MemberCardException(String msg, int code) {
    super(msg, code);
  }
}
