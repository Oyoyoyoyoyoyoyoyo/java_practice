package com.oyogis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * @Value注解来加载yml或者properties配置文件的的参数
     */
    @Value("${valuetest.name}")
    private String nametest;
    @RequestMapping("/hello")
    public String index() {
        //return "hello word";
        return nametest;
    }
}
