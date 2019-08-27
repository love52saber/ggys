package net.seocoo.ggys.module.area.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * 区域模块异常类
 * @author PanChengHao
 * @date 2018/6/5 11:55
 */
public class AreaException extends AppException{
  public AreaException(String msg, int code) {
    super(msg, code);
  }
}
