package com.chuchen.gulimall.ware.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author chuchen
 * @Date 2022/9/18
 * @Description MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.chuchen.gulimall.ware.dao")
public class WareMyBatisConfig {
    //引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置请求页数超过最大页数则返回首页
        paginationInterceptor.setOverflow(true);
        //设置每页最大的限制条数，默认是500，设置为 -1 则为不限制
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
