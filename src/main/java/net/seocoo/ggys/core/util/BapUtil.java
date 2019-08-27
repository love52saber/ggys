package net.seocoo.ggys.core.util;


//import cn.seocoo.platform.unite.ResMessage;
//import cn.seocoo.platform.unite.Result;

import com.alibaba.fastjson.JSON;
import com.tydic.framework.util.ConfigurationFactory;
import com.tydic.framework.util.HttpClientFactory;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.seocoo.ggys.core.tcp.TcpCont;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//import org.apache.axis.client.Call;
//import org.apache.axis.client.Service;

//import javax.xml.rpc.ServiceException;
/**
 * @author wangpan
 * @date 2018/6/13 21:23
 */

public class BapUtil {

//  private static Logger logger = Logger.getLogger(BapUtil.class);
  protected static Logger logger = LoggerFactory.getLogger(BapUtil.class);

  /**
   * freemarker模板文件名称
   */
  private static final String FM_BAP = "unite.ftl";

  /**
   * freemarker模板文件名称
   */
  private static final String RQ_BAP = "request.ftl";
//  /**
//   * 生成bap接口所需要的webService报文
//   * @param svcContentList 各接口已经转换成json格式的报文集合
//   * @param bapTcpContent bap接口控制信息
//   * @return 符合规范的报文信息，如果生成出错，返回null
//   */
//  public static String getWebSvcContent(String content, String header){
//    try {
//      Configuration cfg = ConfigurationFactory.getInstance();
//      Template template = cfg.getTemplate(FM_BAP);
//      Map<String, Object> root = new HashMap<String, Object>();
//      root.put("content", content);
//      root.put("header", header);
//      // 将模板和数据模型合并
//      ByteArrayOutputStream baos = new ByteArrayOutputStream();
//      BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(baos));
//      template.process(root, bos);
//      bos.flush();
//      return baos.toString();
//    } catch (TemplateException e) {
//      logger.error("初始化freemarker模板路径出错", e);
//    } catch (IOException e) {
//      logger.error("IO异常", e);
//    }
//    return null;
//  }

  /**
   * 生成bap接口所需要的webService报文
   * @param content 各接口已经转换成json格式的报文集合
   * @param header bap接口控制信息
   * @return 符合规范的报文信息，如果生成出错，返回null
   */
  public static String getReqSvcContent(String content, String header){
    try {
      freemarker.template.Configuration cfg = ConfigurationFactory.getInstance();
      Template template = cfg.getTemplate(RQ_BAP);
      Map<String, Object> root = new HashMap<String, Object>();
      root.put("content", content);
      root.put("header", header);
      // 将模板和数据模型合并
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(baos));
      template.process(root, bos);
      bos.flush();
      return baos.toString();
    } catch (TemplateException e) {
      logger.error("初始化freemarker模板路径出错", e);
    } catch (IOException e) {
      logger.error("IO异常", e);
    }
    return null;
  }

  /**
   * HttpClient发送请求
   * @param url 请求url
   * @param bodyContent 消息体
   * @return 服务器返回内容
   */
  @SuppressWarnings("deprecation")
  public static String httpSendMsg(String url, String bodyContent) throws IOException{
    PostMethod post=null;
    HttpClient client=null;
    try{
      client = HttpClientFactory.getHttpClient();
      client.setConnectionTimeout(20*1000);
      post = new PostMethod(url);
      post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
      post.setRequestBody(bodyContent);
      post.addRequestHeader("Content-Type",
          "application/x-www-form-urlencoded; text/html; charset=utf-8");
      post.addRequestHeader("User-Agent", "Mozilla/4.0");
      long start = System.currentTimeMillis();
      logger.info("请求报文：" + bodyContent);
      client.executeMethod(post);
      String result = new String(post.getResponseBody(),"UTF-8");

      if(logger.isInfoEnabled()){
        logger.info("响应的编码是："+post.getResponseCharSet());
        long end = System.currentTimeMillis();
        logger.info("统一接口平台接口响应时间:" + (end-start) / 1000 + "秒");
        logger.info("响应结果:"+result);
      }
      return result;
    }finally{
      if(post!=null){
        post.releaseConnection();
        client=null;
      }
    }
  }

//  public  static String postWebServiceRequest(String url,String nameSpace,String  method,String requestMsg,Integer timeout) throws ServiceException, MalformedURLException, RemoteException{
//
//    Service service = new Service();
//    Call call = null;
//    logger.info("探测请求报文："+requestMsg);
//    //请求报文
//    String in = requestMsg;
//    String out = "";
//    call = (Call) service.createCall();
//    call.setTargetEndpointAddress(new java.net.URL(url));
//    call.setTimeout(timeout);
//    // 设置命名空间与调用方法
//    call.setOperationName(new QName(nameSpace,method));
//    out = (String) call.invoke(new Object[] { in });
//    logger.info("探测响应报文："+out);
//
//    System.out.println("in=\n" + in + "\nout=\n" + out);
//
//    return out;
//
//  }

  /** 发送json请求
   *  @param url
   *  @param params
   *  * @return */
  public static String httpSendJson(String url, String params) {
    PostMethod method=null;
    HttpClient client=null;
    try{
      client = HttpClientFactory.getHttpClient();
      client.setConnectionTimeout(20*1000);
      method = new PostMethod(url);
      RequestEntity requestEntity = new StringRequestEntity(params,
          "text/xml", "UTF-8");
      method.setRequestEntity(requestEntity);
      method.releaseConnection();
      client.executeMethod(method);
      String responses = method.getResponseBodyAsString();
      return responses;

    } catch (HttpException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally{
      if(method!=null){
        method.releaseConnection();
        client=null;
      }
    }
    return null;
  }

//  /**
//   * map作为参数请求
//   * @param url
//   * @param params
//   * @return
//   */
//  public static String doPost(String url, Map params){
//    BufferedReader in = null;
//    try {
//      // 定义HttpClient
//      DefaultHttpClient client = new DefaultHttpClient();
//      // 实例化HTTP方法
//      HttpPost request = new HttpPost();
//      request.setURI(new URI(url));
//      //设置参数
//      List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//      for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
//        String name = (String) iter.next();
//        String value = String.valueOf(params.get(name));
//        nvps.add(new BasicNameValuePair(name, value));
//        //System.out.println(name +"-"+value);
//      }
//      request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
//      HttpResponse response = client.execute(request);
//      int code = response.getStatusLine().getStatusCode();
//      if(code == 200){    //请求成功
//        in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));
//        StringBuffer sb = new StringBuffer("");
//        String line = "";
//        String NL = System.getProperty("line.separator");
//        while ((line = in.readLine()) != null) {
//          sb.append(line + NL);
//        }
//        in.close();
//        return sb.toString();
//      }
//      else{   //
//        System.out.println("状态码：" + code);
//        return null;
//      }
//    }
//    catch(Exception e){
//      e.printStackTrace();
//      return null;
//    }finally{
//      try {
//        in.close();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }

  /** 发送json请求
   *
   *  * @return */
//  public static void httpSendFile(String url, String params,HttpServletResponse response) {
//    PostMethod method=null;
//    HttpClient client=null;
//    try{
//      client = HttpClientFactory.getHttpClient();
//      client.setConnectionTimeout(60*1000);
//      method = new PostMethod(url);
//      RequestEntity requestEntity = new StringRequestEntity(params,
//          "text/xml", "UTF-8");
//      method.setRequestEntity(requestEntity);
//      method.releaseConnection();
//      client.executeMethod(method);
//      InputStream inputStream = method.getResponseBodyAsStream();
//      ServletOutputStream out;
//      //设置传输类型
//      response.setContentType("multipart/form-data");
//      // 3.通过response获取ServletOutputStream对象(out)
//      out = response.getOutputStream();
//      int b = 0;
//      byte[] buffer = new byte[512];
//      while (b != -1) {
//        b = inputStream.read(buffer);
//        // 4.写到输出流(out)中
//        if(b != -1){
//          out.write(buffer, 0, b);
//        }
//
//      }
//      inputStream.close();
//      out.close();
//      out.flush();
//    } catch (HttpException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }finally{
//      if(method!=null){
//        method.releaseConnection();
//        client=null;
//      }
//    }
//  }

  public static String generateRequestMessage(String content,String setServiceCode){

    TcpCont tcpCont=new TcpCont();
    tcpCont.setSrcSysID("1003");
    tcpCont.setServiceCode(setServiceCode);
    tcpCont.setSrcSysPassWord("1003");
    tcpCont.setSrcSysSign("123456");
    tcpCont.setTransactionID("1322017119413");
    String header=JSON.toJSONString(tcpCont);
    return BapUtil.getReqSvcContent(content, header);

  }

//  public static Result parseRes(String res){
//    ResMessage msg=JSONObject.parseObject(res, ResMessage.class);
//    Result result = JSONObject.parseObject(msg.getResSvcCont().getResult(), Result.class);
//    return result;
//
//  }

  public static void main(String[] args) throws IOException {
    String url="http://sdk.zyer.cn/SmsService/SmsService.asmx/SendEx";
    String bodyContent="LoginName=ah10000&Password=81884dab600dc921&SmsKind=808&SendSim=18096695591&ExpSmsId=&MsgContext=123456";

    String str=httpSendMsg(url, bodyContent);
    System.out.println(str);

  }
}

