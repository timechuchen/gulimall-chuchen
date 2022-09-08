package com.chuchen.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、导入依赖
 * 2、配置（数据源，MyBatis-plus）
 */

@EnableDiscoveryClient  //开启服务注册与发现功能
@SpringBootApplication
@MapperScan("com.chuchen.gulimall.product.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
