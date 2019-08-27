package net.seocoo.ggys.core.wechat;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * @author wangpan
 * @date 2018/6/13 10:50
 */
public class CreateAccessTokenUtil {
  private static final Logger logger = LoggerFactory.getLogger(CreateAccessTokenUtil.class);
  /**
   * 查询AccessToken 返回对象
   * @param appId
   * @param appSecret
   * @return
   */
  public static AccessToken getAccessToken(String appId, String appSecret){
    String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
    requestUrl =  requestUrl.replace("APPID", appId);
    requestUrl =  requestUrl.replace("SECRET", appSecret);

    AccessToken accessToken = null;
    logger.info("getAccessToken===requestUrl===="+requestUrl);
    JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
    if (jsonObject != null){
      try {
        logger.info("getAccessToken===jsonObject===="+jsonObject.toString());
        String access_token = jsonObject.getString("access_token");
        String expires_in = jsonObject.getString("expires_in");
        accessToken = new AccessToken();
        accessToken.setAppId(appId);
        accessToken.setAppSecret(appSecret);
        accessToken.setAccessToken(access_token);
        accessToken.setExpiresIn(Integer.parseInt(expires_in));
        accessToken.setCreateTime(new Date());
        logger.info("getAccessToken======success==AccessToken===="+access_token);
      } catch (Exception e) {
        String errCode = jsonObject.getString("errcode");
        String errMsg = jsonObject.getString("errmsg");
        logger.error("获取token失败errcode:{" + errCode + "} errmsg{" + errMsg + "}");
      }
    }
    return accessToken;
  }
}
