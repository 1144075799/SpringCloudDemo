package com.mysqlSpringCould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy    //启用zuul  自带熔断和自动注册到eureka,注意需要导入eureka的client依赖
public class ApiGetWay {
    public static void main(String[] args) {
        SpringApplication.run(ApiGetWay.class,args);
    }
}
