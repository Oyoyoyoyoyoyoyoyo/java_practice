package com.oyoyoyoyo.config;

import org.springframework.context.annotation.Configuration;
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
     * 首页视图控制
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");

    }
}
