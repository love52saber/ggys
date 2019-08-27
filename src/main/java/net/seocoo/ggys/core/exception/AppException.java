package net.seocoo.ggys.core.exception;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc  所有项目子业务中出现的自定义异常需继承此公共业务型异常
 */
public class AppException extends RuntimeException
{
    private int errorCode;

    public static int buildErrorCode(int code)
    {
        return code;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public AppException(String msg, int code) {
        super(msg);
        this.errorCode = code;
    }
}