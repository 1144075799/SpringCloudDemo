package com.mysqlSpringCould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@EnableEurekaClient
public class ConsumerOrder
{
    @Bean   //相当于xml 中的 bean标签，主要用于调用当前方法获取到指定对象
    public RestTemplate getTemp(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder.class,args);
    }
}
