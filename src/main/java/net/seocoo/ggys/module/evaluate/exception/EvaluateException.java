package net.seocoo.ggys.module.evaluate.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * 评价异常类
 * @author PanChengHao
 * @date 2018/6/13 17:34
 */
public class EvaluateException extends AppException {
  public EvaluateException(String msg, int code) {
    super(msg, code);
  }
}
