package net.seocoo.ggys.module.merchant.exception;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @Author xieheng
 * @Data 2018/5/30 0030 17:28
 * @Email xieheng91@163.com
 * @Desc 商户模块异常
 */
public class MerchantException extends AppException {
    public MerchantException(String msg, int code) {
        super(msg, code);
    }
}
