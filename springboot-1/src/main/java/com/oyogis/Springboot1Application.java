package com.oyogis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author oyoyoyoyoyoyo
 */
@EnableSwagger2
@SpringBootApplication
public class Springboot1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }

}
