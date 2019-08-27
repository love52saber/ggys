package net.seocoo.ggys.module.order.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * 订单异常信息
 * @author ZengXiaoLiang
 * @date 2018/6/7 17:09
 **/
public class OrderException extends AppException {
  public OrderException(String msg, int code) {
    super(msg, code);
  }
}
