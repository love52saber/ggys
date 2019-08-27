package net.seocoo.ggys.core.util.map;

import net.seocoo.ggys.core.util.Pair;
import net.seocoo.ggys.core.util.PropertiesUtils;

/**
 * 地理位置工具类 经纬度
 * @author wangpan
 * @date 2018/6/12 20:16
 */
public class LocationUtil {
  private static String requestUrl= PropertiesUtils.getGaoDeMap().getProperty("GeoDe.RequestUrl")+"/regeo";

  private static String key=PropertiesUtils.getGaoDeMap().getProperty("GeoDe.Key");

  public static void main(String[] args) {

//    transform(31.867193,117.28147,22.90,32.3);
    String ss = transform2Str(31.865322,117.280914);
    System.out.println(ss);
  }
  /**
   * 3.14159265358979324;
   */
  static double pi = Math.PI;

  static double a = 6378245.0;
  static double ee = 0.00669342162296594323;


  /**
   * World Geodetic System ==> Mars Geodetic System
   * 将微信获取的经纬度 转换成火星坐标
   * @param wgLat
   * @param wgLon
   * @return
   */
  public static String transform2Str(double wgLat, double wgLon) {
    double mgLat;
    double mgLon;
    if (outOfChina(wgLat, wgLon)) {
      mgLat = wgLat;
      mgLon = wgLon;
      return mgLon+","+mgLat;
    }
    double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
    double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
    double radLat = wgLat / 180.0 * pi;
    double magic = Math.sin(radLat);
    magic = 1 - ee * magic * magic;
    double sqrtMagic = Math.sqrt(magic);
    dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
    dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
    mgLat = wgLat + dLat;
    mgLon = wgLon + dLon;

    return mgLon+","+mgLat;
  }

  /**
   * World Geodetic System ==> Mars Geodetic System
   * 将微信获取的经纬度 转换成火星坐标
   * @param wgLat
   * @param wgLon
   * @return
   */
  public static Pair transform2Pair(double wgLat, double wgLon) {
    double mgLat;
    double mgLon;
    if (outOfChina(wgLat, wgLon)) {
      mgLat = wgLat;
      mgLon = wgLon;
      // mgLon+","+mgLat;
      return new Pair(mgLon,mgLat);
    }
    double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
    double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
    double radLat = wgLat / 180.0 * pi;
    double magic = Math.sin(radLat);
    magic = 1 - ee * magic * magic;
    double sqrtMagic = Math.sqrt(magic);
    dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
    dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
    mgLat = wgLat + dLat;
    mgLon = wgLon + dLon;

    return new Pair(mgLon,mgLat);
  }

  static boolean outOfChina(double lat, double lon)  {
    if (lon < 72.004 || lon > 137.8347)
      return true;
    if (lat < 0.8293 || lat > 55.8271)
      return true;
    return false;
  }

  static double transformLat(double x, double y)  {
    double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
    ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
    ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
    ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
    return ret;
  }

  static double transformLon(double x, double y)  {
    double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
    ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
    ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
    ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
    return ret;
  }

  /**
   * 根据经纬度 逆地理编码查询位置信息
   * @param lat
   * @param lon
   * @return
   */
  public static String getLocationInfo(String lat, String lon){

    String param = "key="+key+"&location="+lon+","+lat;
    String responseStr = HttpUtil.sendGet(requestUrl,param);
    System.out.println("responseStr==="+responseStr);

    return responseStr;
  }
}
