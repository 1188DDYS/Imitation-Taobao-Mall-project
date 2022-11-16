package com.xunqi.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 1、spring-session依赖
 * 2、spring-session配置
 * 3、LoginInterceptor拦截器
 *
 *
 * @EnableFeignClients(basePackages = "com.xunqi.gulimall.member.feign")
 * 开启远程调用功能
 */

@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.xunqi.gulimall.member.feign")
//开启了远程调用的服务，远程接口在feigh下，相应的包在com.xunqi.gulimall.member.feign
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
