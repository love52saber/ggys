package net.seocoo.ggys.core.util.map;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.seocoo.ggys.core.util.PropertiesUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

/**
 * 高德地图工具类
 * @author PanChengHao
 * @date 2018/6/6 20:06
 */

public class MapUtil {

  private static String requestUrl= PropertiesUtils.getGaoDeMap().getProperty("GeoDe.RequestUrl");

  private static String key=PropertiesUtils.getGaoDeMap().getProperty("GeoDe.Key");
  /**
   * 获取经纬度
   * @param requestUrl 请求地址
   * @param requestParam 请求参数
   * @return json
   */
  private static String getGeoCoding(String requestUrl,Map requestParam){
    String params=sortMapToQueryString(requestParam);
    String result=HttpUtil.sendGet(requestUrl,params);
    return result;
  }

  /**
   * 逆地理编码
   * @param requestUrl 请求地址
   * @param requestParam 请求参数
   * @return
   */
  private static String queryAddressDetail(String requestUrl,Map requestParam){
    String params=sortMapToQueryString(requestParam);
    String result=HttpUtil.sendGet(requestUrl,params);
    return result;
  }

  /**
   * map拼接请求参数，并返回参数值拼接后的字符串
   * @param map 源参数map
   * @return 参数值拼接后的字符串
   */
  public static String sortMapToQueryString(Map<String, Object> map) {
    Set<String> keySet = map.keySet();
    List<String> keyList = new ArrayList<>(keySet);

    StringBuilder buffer = new StringBuilder();
    for (String key : keyList) {
      if (buffer.length() > 0) {
        buffer.append('&');
      }
      buffer.append(key).append("=").append(map.get(key));
    }
    return buffer.toString();
  }

  private static double EARTH_RADIUS = 6371.393;
  private static double rad(double d)
  {
    return d * Math.PI / 180.0;
  }

  /**
   * 计算两个经纬度之间的距离
   * @param lat1
   * @param lng1
   * @param lat2
   * @param lng2
   * @return
   */
  public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
  {
    double radLat1 = rad(lat1);
    double radLat2 = rad(lat2);
    double a = radLat1 - radLat2;
    double b = rad(lng1) - rad(lng2);
    double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
    s = s * EARTH_RADIUS;
    s = Math.round(s * 1000);
    return s;
  }

  /**
   * 获取经纬度
   * @return
   */
  public static String getLatLng(String address,String city){
    Map<String,Object> requestParam=new HashMap<>();
    String reqUrl=requestUrl+"/geo";
    requestParam.put("key",key);
    requestParam.put("address",address);
    requestParam.put("city",city);
    String requestResult=getGeoCoding(reqUrl, requestParam);
    JSONObject  jsonResult= JSON.parseObject(requestResult);
    String location=null;
    if("1".equals(jsonResult.get("status")) && "1".equals(jsonResult.get("count"))){
      JSONArray geocodesArr=jsonResult.getJSONArray("geocodes");
      Object locationObject=geocodesArr.getJSONObject(0).get("location");
      if(locationObject!=null){
        location=locationObject.toString();
      }
    }
    return location;
  }

  /**
   * 根据经纬度获取详细地址
   * @return
   */
  public static String getAddressDetail(String lng, String lat,String radius){
    String location=lng+","+lat;
    if("".equals(radius) || radius==null){
      radius="1000";
    }
    Map<String,Object> requestParam=new HashMap<>();
    String reqUrl=requestUrl+"/regeo";
    String extensions="base";
    //批量查询控制  可选
    String batch="false";
    //道路等级  可选
    String roadlevel="0";
    requestParam.put("key",key);
    requestParam.put("extensions", extensions);
    requestParam.put("batch", batch);
    requestParam.put("roadlevel", roadlevel);
    requestParam.put("location",location);
    requestParam.put("radius",radius);
    String requestResult=queryAddressDetail(reqUrl,requestParam);
    JSONObject  jsonResult= JSON.parseObject(requestResult);

    String formattedAddress=null;
    if("1".equals(jsonResult.get("status"))){
      JSONObject regeocode=JSONObject.parseObject(jsonResult.get("regeocode").toString());
      if(regeocode!=null){
        formattedAddress=regeocode.get("formatted_address").toString();
      }
    }
    return formattedAddress;
  }
}
