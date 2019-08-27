package net.seocoo.ggys.module.merchant.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @Author xieheng
 * @Data 2018/5/31 0031 15:58
 * @Email xieheng91@163.com
 * @Desc 二级分类异常
 */
public class SecondClassifyException extends AppException {
    public SecondClassifyException(String msg, int code) {
        super(msg, code);
    }
}
