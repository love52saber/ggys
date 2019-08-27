package net.seocoo.ggys.module.coupon.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * 优惠券模板自定义异常
 * @author ZengXiaoLiang
 * @date 2018/5/29 21:09
 **/
public class CouponException extends AppException {
  public CouponException(String msg, int code) {
    super(msg, code);
  }
}
