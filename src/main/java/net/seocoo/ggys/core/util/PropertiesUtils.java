package net.seocoo.ggys.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author PanChengHao
 * @date 2018/6/13 14:01
 */
public class PropertiesUtils {
  private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
  private static Properties gaoDeMap = new Properties();

  static {
    InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("GeoDeMap.properties");
    try {
      gaoDeMap.load(inputStream);
    } catch (Exception e) {
      logger.error("读取配置文件出错", e);
    }

    try {
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Properties getGaoDeMap() {
    return gaoDeMap;
  }
}
