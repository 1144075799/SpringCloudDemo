package com.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig01 {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

}
