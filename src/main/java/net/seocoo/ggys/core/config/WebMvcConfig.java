package net.seocoo.ggys.core.config;

import net.seocoo.ggys.core.asp.LoginUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/22 10:29
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private LoginUserInterceptor loginUserInterceptor;
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    super.addInterceptors(registry);
//    registry.addInterceptor(loginUserInterceptor).addPathPatterns("/**").excludePathPatterns("/user/**","/swagger-resources/**");
  }

//
//  @Override
//  public void addCorsMappings(CorsRegistry registry) {
//    registry
//        .addMapping("/**")
//        .allowCredentials(true);
//  }


}
