package net.seocoo.ggys.module.takeout.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @Author xieheng
 * @Data 2018/6/4 0004 14:49
 * @Email xieheng91@163.com
 * @Desc 外卖模块异常
 */
public class TakeOutTypeException extends AppException {
    public TakeOutTypeException(String msg, int code) {
        super(msg, code);
    }
}
