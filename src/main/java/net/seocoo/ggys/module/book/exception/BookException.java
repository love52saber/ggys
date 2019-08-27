package net.seocoo.ggys.module.book.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * 预约自定义异常
 * @author PanChengHao
 * @date 2018/5/31 15:43
 */
public class BookException extends AppException {
    public BookException(String msg, int code) {
        super(msg, code);
    }
}
