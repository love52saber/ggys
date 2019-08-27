package net.seocoo.ggys.core.api;
/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc  基本状态码封装
 */
public class RequestCode {
    public static final int success = 200;
    public static final int success_created = 201;
    public static final int success_async = 202;
    public static final int syntax_error = 400;
    public static final int unauthorized_error = 401;
    public static final int forbid_error = 403;
    public static final int resNotFind_error = 404;
    public static final int resIsDelete_error = 410;
    public static final int noContentLength_error = 411;
    public static final int missingParameter_error = 412;
    public static final int content_forbid_error = 415;
    public static final int range_error = 416;
    public static final int semantic_error = 422;
    public static final int locked_error = 423;
    public static final int server_error = 500;
    public static final int server_unrealized_error = 501;
    public static final int none = 0;
    public static final int Not_Acceptable = 406;
    public static final int Unsupported_Media_Type = 415;
    public static final int Method_Not_Allowed = 405;
    public static final int Form_Validate_Error = 701;
    /**
     * 操作提示 600
     */
    public static final int Operate_Tip = 600;

    /**
     * 用户未登陆，token失效
     */
    public static final int Not_Login = 700;

    public RequestCode() {
    }
}
