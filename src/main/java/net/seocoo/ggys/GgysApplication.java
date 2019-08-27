package net.seocoo.ggys;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/25 0025 17:56
 * @Email xieheng91@163.com
 * @Desc TODO
 */
@SpringBootApplication
public class GgysApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(GgysApplication.class, args);
  }

  /**
   * 替换spring的jackJson为FastJson
   */
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    FastJsonConfig config = new FastJsonConfig();
    config.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue);
    // 序列化时间格式 add by ZengXiaoLiang
    SerializeConfig serializeConfig = new SerializeConfig();
    serializeConfig.put(Date.class, new SimpleDateFormatSerializer( "yyyy-MM-dd HH:mm:ss"));
    config.setSerializeConfig(serializeConfig);

    //解决中文乱码
    List<MediaType> fastMediaTypes = new ArrayList<>();
    fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    converter.setSupportedMediaTypes(fastMediaTypes);

    converter.setFastJsonConfig(config);
    return new HttpMessageConverters(converter);
  }
}
