package com.oyoyoyo.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Date:2020/11/22
 * Decription:<描述>
 *
 * @Author:oyoyoyoyoyoyo
 */
@MapperScan("com.oyoyoyo.mapper")
//扫描mapper文件夹
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {
    /**
     * 注册乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
