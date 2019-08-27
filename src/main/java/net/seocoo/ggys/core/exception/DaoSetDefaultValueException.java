package net.seocoo.ggys.core.exception;

/**
 * @Author xieheng
 * @Data 2018/6/5 0005 15:06
 * @Email xieheng91@163.com
 * @Desc dao操作时设置新增的默认字段或者更新的默认字段值时出现错误
 */
public class DaoSetDefaultValueException extends AppException{
    public DaoSetDefaultValueException(String msg, int code) {
        super(msg, code);
    }
}
