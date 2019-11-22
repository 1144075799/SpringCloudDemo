package com.mysqlSpringCould.feign;

import com.config.FeignClientConfig02;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test",url = "http://localhost:9000",configuration = FeignClientConfig02.class)
public interface FeignClient2 {


    @RequestMapping("/eureka/apps/{servicename}")
    String getServiceInfo(@PathVariable("servicename") String servicename);

}
