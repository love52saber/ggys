package net.seocoo.ggys.module.merchant.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 15:22
 * @Email xieheng91@163.com
 * @Desc 一级分类异常
 */
public class FirstClassifyException extends AppException {
    public FirstClassifyException(String msg, int code) {
        super(msg, code);
    }
}
