package com.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig02 {

    /**
     * 配置要输出的日志是那些，必须在debug模式下才可以输出
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
