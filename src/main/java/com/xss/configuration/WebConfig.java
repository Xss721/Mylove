package com.xss.configuration;


import com.xss.interceptor.loginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/fronts/**","/images/**","/js/**","/login/**","/");
    }
}