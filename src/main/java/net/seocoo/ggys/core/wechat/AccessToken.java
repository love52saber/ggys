package net.seocoo.ggys.core.wechat;
import java.util.Date;
/**
 * @author wangpan
 * @date 2018/6/13 10:47
 */
public class AccessToken {

  private String appId;
  private String appSecret;
  /**
   * 调用微信接口用的access_token
   */
  private String accessToken;
  /**
   * access_token创建时间
   */
  private Date createTime;
  /**
   * access_token有效时间
   */
  private Integer expiresIn;

  public String getAppId() {
    return appId;
  }
  public void setAppId(String appId) {
    this.appId = appId;
  }
  public String getAppSecret() {
    return appSecret;
  }
  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }
  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
  public Date getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
  public Integer getExpiresIn() {
    return expiresIn;
  }
  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }
}
