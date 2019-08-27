package net.seocoo.ggys.core.exception;

import com.alibaba.fastjson.JSONObject;
import net.seocoo.ggys.core.api.ApiResult;
import net.seocoo.ggys.core.api.BaseApi;
import net.seocoo.ggys.core.api.RequestCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc 全局处理 Controller 层异常,
 * 防止service层为了直接失败抛出异常为了让spring处理回滚，controller层大量冗余的try catch操作
 * Exception 处理所有不可知的异常
 * AppException 处理所有业务异常
 * MethodArgumentNotValidException 参数验证异常
 */

@ControllerAdvice
public class GlobalExceptionHandler extends BaseApi {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private void log(HttpServletRequest req, Exception e, int code) {
        LOG.error("error code:{},message:{}", code, e.getMessage());
        LOG.error(e.getMessage(), e);
        LOG.info("请求IP：{}", req.getRemoteAddr());
        LOG.info("请求路径：{}", req.getRequestURL());
        LOG.info("请求方式：{}", req.getMethod());
        LOG.info("请求参数：{}", JSONObject.toJSONString(req.getParameterMap()));
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ApiResult jsonErrorHandler(HttpServletRequest req, Exception e)
            throws Exception {
        int code = AppException.buildErrorCode((e instanceof AppException) ? ((AppException) e).getErrorCode() : RequestCode.none);
        log(req, e, code);
        return error(code, e.getMessage());
    }


    /**
     * 参数验证异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ApiResult handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e)
            throws Exception {
        int code = AppException.buildErrorCode(RequestCode.Form_Validate_Error);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessage = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));

        fieldErrors.forEach(err -> {
            LOG.error("异常参数 {},异常原因 {}", err.getField(), err.getDefaultMessage());
        });
        log(req, e, code);

        return error(code, errorMessage);
    }
}