package net.seocoo.ggys.core.base;

import net.seocoo.ggys.core.api.BaseApi;
import net.seocoo.ggys.core.api.RequestCode;
import net.seocoo.ggys.core.exception.AppException;
import net.seocoo.ggys.core.util.RedisUtil;
import net.seocoo.ggys.core.util.StringEx;
import net.seocoo.ggys.core.util.Web;
import net.seocoo.ggys.module.merchant.entity.MerchantDO;
import net.seocoo.ggys.module.merchant.service.MerchantService;
import net.seocoo.ggys.module.user.entity.UserInfoDO;
import net.seocoo.ggys.module.user.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc controller基类
 */
public class BaseController extends BaseApi {

  @Autowired
  private RedisUtil redisUtil;
  @Autowired
  private UserInfoService userInfoService;

  @Autowired
  private MerchantService merchantService;

  protected Logger logger = LoggerFactory.getLogger(this.getClass());

  protected UserInfoDO getUserInfoFromToken(String token) {
    //TODO token注释
//    if(StringUtils.isEmpty(token)) {
//      throw new AppException("token不能为空", RequestCode.Operate_Tip);
//    }
    UserInfoDO userInfoDO = (UserInfoDO) redisUtil.get(token);
    //TODO 此处开发需要，暂时内置默认值，等上线时删除此段代码 by zxl
    if (userInfoDO == null) {
      userInfoDO = this.userInfoService.getUserInfoById(20);
    }
    return userInfoDO;
  }

  /**
   * 查询当前token的登陆用户所属商家Id
   * @return 商家Id。用户没有登录或者用户不是商家类型返回null
   *
   */
  protected Integer getMerchantId4Token(){
    UserInfoDO userInfo = this.getUserInfoFromToken(this.getToken());
    if(userInfo == null) {
      return null;
    }
    return this.merchantService.getMerchantIdByMerchantUserId(userInfo.getId());
  }

    /**
     * 通过当前线程的请求中各个部分尝试获取当前用户token
     *
     * @return
     */
    protected  String getToken() {
        HttpServletRequest request = Web.getCurrentRequest();

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token"))
                    return cookie.getValue();
            }
        }

        String token = request.getHeader("token");
        if (!StringEx.stringIsNullOrEmpty(token)) {
            return token;
        }
        return request.getParameter("token");
    }
}
