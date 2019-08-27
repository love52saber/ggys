package net.seocoo.ggys.core.asp;

import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录用户拦截器
 * @author ZengXiaoLiang
 * @date 2018/6/22 10:32
 **/
@Component
public class LoginUserInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private RedisUtil redisUtil;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = request.getHeader("token");
    if(StringUtils.isEmpty(token)){
      throw new AppException("用户未登录,请先登录!", RequestCode.Not_Login);
    }

    UserInfoDO userInfo = (UserInfoDO) redisUtil.get(token);
    if(userInfo == null) {
      throw new AppException("用户未登录,请先登录!", RequestCode.Not_Login);
    }
    return super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    super.afterCompletion(request, response, handler, ex);
  }

  @Override
  public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    super.afterConcurrentHandlingStarted(request, response, handler);
  }
}
