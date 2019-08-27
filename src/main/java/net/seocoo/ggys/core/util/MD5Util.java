package net.seocoo.ggys.core.util;

import java.security.MessageDigest;

/**
 * md5加密工具类
 * @author wangpan
 * @date 2018/6/6 9:47
 */
public class MD5Util {
  private static String byteArrayToHexString(byte b[]) {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++)
      resultSb.append(byteToHexString(b[i]));

    return resultSb.toString();
  }

  private static String byteToHexString(byte b) {
    int n = b;
    if (n < 0)
      n += 256;
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  public static String MD5Encode(String origin, String charsetname) {
    String resultString = null;
    try {
      resultString = new String(origin);
      MessageDigest md = MessageDigest.getInstance("MD5");
      if (charsetname == null || "".equals(charsetname)){
        resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
      } else{
        resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
      }
    } catch (Exception exception) {
    }
    return resultString;
  }

  /**
   * 微信官方MD5算法
   * @param data
   * @return
   * @throws Exception
   */
  public static String MD5(String data) throws Exception {
    java.security.MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] array = md.digest(data.getBytes("UTF-8"));
    StringBuilder sb = new StringBuilder();
    for (byte item : array) {
      sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
    }
    return sb.toString().toUpperCase();
  }

  private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
      "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}
