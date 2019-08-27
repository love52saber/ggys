package net.seocoo.ggys.core.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @Author xieheng
 * @Data 2018/6/8 0008 14:56
 * @Email xieheng91@163.com
 * @Desc web
 */
public class Web {
    public Web() {
    }

    public static HttpServletRequest getCurrentRequest() throws IllegalStateException {
        ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            throw new IllegalStateException("当前线程中不存在 Request 上下文");
        } else {
            return attrs.getRequest();
        }
    }

    public static HttpServletResponse getCurrentResponse() throws IllegalStateException {
        ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (attrs == null) {
            throw new IllegalStateException("当前线程中不存在 Request 上下文");
        } else {
            return attrs.getResponse();
        }
    }

    public static String getRqeustParameter(String name) {
        try {
            HttpServletRequest q = getCurrentRequest();
            return q.getParameter(name);
        } catch (IllegalStateException var2) {
            return null;
        }
    }

    public static String getRqeustParameter(HttpServletRequest q, String name) {
        return q == null ? null : q.getParameter(name);
    }
}
