package com.chuchen.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 远程调用别的服务：
 *  1、引入 open-feign
 *  2、编写一个接口，告诉 SpringCloud 这个接口需要调用远程服务（声明接口的每一个方法都是调用远程服务的哪个请求）
 *  3、开启远程调用功能
 */

@EnableDiscoveryClient  //开启服务注册与发现功能
@EnableFeignClients(basePackages = "com.chuchen.gulimall.member.feign") //开启远程调用功能
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
