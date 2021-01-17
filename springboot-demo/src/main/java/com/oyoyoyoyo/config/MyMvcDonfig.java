package com.oyoyoyoyo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Date:2021/1/14
 * Decription:<描述>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Configuration
public class MyMvcDonfig implements WebMvcConfigurer {

    /**
     * 首页视图控制/路由转换
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截非正常路径
        registry.addInterceptor(new LoginHandlerIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/css/**", "/js/**", "/img/**");
    }
}
