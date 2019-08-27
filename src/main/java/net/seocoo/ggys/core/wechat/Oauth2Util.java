package net.seocoo.ggys.core.wechat;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangpan
 * @date 2018/6/3
 */
public class Oauth2Util {
  private static Logger Log = LoggerFactory.getLogger(Oauth2Util.class);

  /**
   * 1、获取Oauth2 acess_token
   *
   * @param appId
   * @param appSecret
   * @param code
   * @return
   * @author cdw
   */
  public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
    WeixinOauth2Token wot = null;
    String requesturl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    requesturl = requesturl.replace("APPID", appId);
    requesturl = requesturl.replace("SECRET", appSecret);
    requesturl = requesturl.replace("CODE", code);

    JSONObject jsonObject = WeixinUtil.httpRequest(requesturl, "GET", null);
    if (jsonObject != null) {
      try {
        wot = new WeixinOauth2Token();
        wot.setAccessToken(jsonObject.getString("access_token"));
        wot.setExpiresIn(jsonObject.getInteger("expires_in"));
        wot.setRefreshToken(jsonObject.getString("refresh_token"));
        wot.setOpenId(jsonObject.getString("openid"));
        wot.setScope(jsonObject.getString("scope"));
      } catch (Exception e) {
        wot = null;
        String errCode = jsonObject.getString("errcode");
        String errMsg = jsonObject.getString("errmsg");
        Log.error("获取网页信息的失败errcode:{" + errCode + "} errmsg{" + errMsg + "}");
      }

    }

    return wot;
  }

  /**
   * 2、 刷新Oauth2 acess_token
   *
   * @param appId
   * @param refreshToken
   * @return
   * @author cdw
   */
  public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
    WeixinOauth2Token wot = null;

    String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

    requestUrl.replace("APPID", appId);
    requestUrl.replace("REFRESH_TOKEN", refreshToken);

    JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
    if (jsonObject != null) {
      try {
        wot = new WeixinOauth2Token();
        wot.setAccessToken(jsonObject.getString("access_token"));
        wot.setExpiresIn(jsonObject.getInteger("expires_in"));
        wot.setRefreshToken(jsonObject.getString("refresh_token"));
        wot.setOpenId(jsonObject.getString("openid"));
        String scope = jsonObject.getString("scope");
        System.out.println("----scope-----" + scope);
        wot.setScope(scope);
        //wot.setScope(jsonObject.getString("scope"));
      } catch (Exception e) {
        wot = null;
        String errCode = jsonObject.getString("errcode");
        String errMsg = jsonObject.getString("errmsg");
        Log.error("获取网页信息的失败errcode:{" + errCode + "} errmsg{" + errMsg + "}");
      }
    }

    return wot;
  }

  public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
    SNSUserInfo uinfo = null;
    String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    System.out.println(accessToken);
    System.out.println(openId);

    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
    requestUrl = requestUrl.replace("OPENID", openId);

    JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
    System.out.println("jsonObject=="+JSONObject.toJSONString(jsonObject));
    if (jsonObject != null) {
      try {
        uinfo = new SNSUserInfo();

        uinfo.setCity(jsonObject.getString("city"));
        uinfo.setCountry(jsonObject.getString("country"));
        uinfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
        uinfo.setNickname(jsonObject.getString("nickname"));
        uinfo.setOpenId(jsonObject.getString("openid"));
//                uinfo.setPrivilegelist(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));

        uinfo.setProvince(jsonObject.getString("province"));
        uinfo.setSex(jsonObject.getInteger("sex"));
        //uinfo.setUnionid(jsonObject.getString("unionid"));

      } catch (Exception e) {
        uinfo = null;
        String errCode = jsonObject.getString("errcode");
        String errMsg = jsonObject.getString("errmsg");
        Log.error("获取网页信息的失败errcode:{" + errCode + "} errmsg{" + errMsg + "}");

      }
    }

    return uinfo;

  }
}
