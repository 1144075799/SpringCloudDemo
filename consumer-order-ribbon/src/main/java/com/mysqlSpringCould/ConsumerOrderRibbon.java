package com.mysqlSpringCould;

import com.TestConfig1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-USER",configuration = TestConfig1.class)
public class ConsumerOrderRibbon
{
    @Bean   //相当于xml 中的 bean标签，主要用于调用当前方法获取到指定对象
    public RestTemplate getTemp(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderRibbon.class,args);
    }
}
