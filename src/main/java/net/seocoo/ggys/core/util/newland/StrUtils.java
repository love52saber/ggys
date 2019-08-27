package net.seocoo.ggys.core.util.newland;
import org.apache.commons.lang3.StringUtils;
import java.util.Collection;
import java.util.Map;
/**
 * 字符串工具类
 * @author wangpan
 * @date 2018/6/13 21:17
 */
public class StrUtils extends StringUtils{
  /**
   * 判断对象是否Empty(null或元素为0)<br>
   * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
   *
   * @param pObj
   *            待检查对象
   * @return boolean 返回的布尔值
   */
  @SuppressWarnings("rawtypes")
  public static boolean isEmpty(Object pObj) {
    if (pObj == null)
      return true;

    if (pObj instanceof String) {
      if (((String) pObj).length() == 0) {
        return true;
      }
    } else if (pObj instanceof Collection) {
      if (((Collection) pObj).size() == 0) {
        return true;
      }
    } else if (pObj instanceof Map) {
      if (((Map) pObj).size() == 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * 判断对象是否为NotEmpty(!null或元素>0)<br>
   * 实用于对如下对象做判断:String Collection及其子类 Map及其子类
   *
   * @param pObj
   *            待检查对象
   * @return boolean 返回的布尔值
   */
  @SuppressWarnings("rawtypes")
  public static boolean isNotEmpty(Object pObj) {
    if (pObj == null)
      return false;

    if (pObj instanceof String) {
      if (((String) pObj).length() == 0) {
        return false;
      }
    } else if (pObj instanceof Collection) {
      if (((Collection) pObj).size() == 0) {
        return false;
      }
    } else if (pObj instanceof Map) {
      if (((Map) pObj).size() == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 连接字符串
   * @param
   * @return
   */
  public static String contract(String value1,String value2,String split) {
    if(StrUtils.isEmpty(value1)){
      value1 = value2+split;
    }else{
      value1 = value1+value2+split;
    }
    return value1;
  }
}
