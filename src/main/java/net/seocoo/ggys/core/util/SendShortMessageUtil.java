package net.seocoo.ggys.core.util;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * 发送短信验证码
 * @author wangpan
 * @date 2018/6/9 10:40
 */
public class SendShortMessageUtil {
  /**
   * 服务http地址
   */
  private static String BASE_URI = "http://yunpian.com";
  /**
   * 服务版本号
   */
  private static String VERSION = "v1";
  /**
   * 编码格式
   */
  private static String ENCODING = "UTF-8";
  /**
   * 查账户信息的http地址
   */
  private static String URI_GET_USER_INFO = BASE_URI + "/" + VERSION + "/user/get.json";
  /**
   * 通用发送接口的http地址
   */
  private static String URI_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/send.json";
  /**
   * 模板发送接口的http地址
   */
  private static String URI_TPL_SEND_SMS = BASE_URI + "/" + VERSION + "/sms/tpl_send.json";

  private static 	String apikey = "5db8dab6f45565c46c6fcb472cfb6be4";
  /**
   * 取账户信息
   * @return json格式字符串
   * @throws IOException
   */
  public static String getUserInfo(String apikey) throws IOException{
    HttpClient client = new HttpClient();
    HttpMethod method = new GetMethod(URI_GET_USER_INFO+"?apikey="+apikey);
    HttpMethodParams param = method.getParams();
    param.setContentCharset(ENCODING);
    client.executeMethod(method);
    return method.getResponseBodyAsString();
  }
  /**
   * 发短信
   * @param text　短信内容　
   * @param mobile　接受的手机号
   * @return json格式字符串
   * @throws IOException
   */
  public static String sendSms(String text, String mobile) throws IOException{
    HttpClient client = new HttpClient();
    NameValuePair[] nameValuePairs = new NameValuePair[3];
    nameValuePairs[0] = new NameValuePair("apikey", apikey);
    nameValuePairs[1] = new NameValuePair("text", text);
    nameValuePairs[2] = new NameValuePair("mobile", mobile);
    PostMethod method = new PostMethod(URI_SEND_SMS);
    method.setRequestBody(nameValuePairs);
    HttpMethodParams param = method.getParams();
    param.setContentCharset(ENCODING);
    client.executeMethod(method);
    return method.getResponseBodyAsString();
  }

  /**
   * 通过模板发送短信
   * @param apikey apikey
   * @param tpl_id　模板id
   * @param tpl_value　模板变量值　
   * @param mobile　接受的手机号
   * @return json格式字符串
   * @throws IOException
   */
  public static String tplSendSms(String apikey, long tpl_id, String tpl_value, String mobile) throws IOException{
    HttpClient client = new HttpClient();
    NameValuePair[] nameValuePairs = new NameValuePair[4];
    nameValuePairs[0] = new NameValuePair("apikey", apikey);
    nameValuePairs[1] = new NameValuePair("tpl_id", String.valueOf(tpl_id));
    nameValuePairs[2] = new NameValuePair("tpl_value", tpl_value);
    nameValuePairs[3] = new NameValuePair("mobile", mobile);
    PostMethod method = new PostMethod(URI_TPL_SEND_SMS);
    method.setRequestBody(nameValuePairs);
    HttpMethodParams param = method.getParams();
    param.setContentCharset(ENCODING);
    client.executeMethod(method);
    return method.getResponseBodyAsString();
  }

  public static void main(String[] args) throws IOException {
    //修改为您的apikey
    //修改为您的手机号
    //String mobile = "15056063590";
    String mobile="15156522646";

    /**************** 查账户信息调用示例 *****************/
//		System.out.println(SendShortMessageUtil.getUserInfo(apikey));

    /**************** 使用通用接口发短信 *****************/
    //设置您要发送的内容
    String text = "【尚果科技】您的验证码是0715";
    //发短信调用示例
    System.out.println(SendShortMessageUtil.sendSms(text, mobile));

    /**************** 使用模板接口发短信 *****************/
    //设置模板ID，如使用1号模板:您的验证码是#code#【#company#】
    long tpl_id=1;
    //设置对应的模板变量值
    String tpl_value="#code#=1234&#company#=尚果科技";
    //模板发送的调用示例
//		System.out.println(SendShortMessageUtil.tplSendSms(apikey, tpl_id, tpl_value, mobile));
  }
}