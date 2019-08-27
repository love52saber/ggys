package net.seocoo.ggys.core.api;

import net.seocoo.ggys.core.exception.AppException;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc web层响应返回封装
 */
public abstract class BaseApi {
  protected ApiResult result(int code, Object data) {
    ApiResult res = new ApiResult();

    ResultInfo p = res.getRt();
    p.setStatus(AppException.buildErrorCode(code));
    res.setRt(p);
    res.setData(data);
    return res;
  }

  protected ApiResult success(Object data) {
    return result(200, data);
  }

  protected ApiResult success() {
    return result(200, "操作成功");
  }

  protected ApiResult error(int error) {
    return result(error, null);
  }

  protected ApiResult error(int error, String msg) {
    return result(error, msg);
  }
}