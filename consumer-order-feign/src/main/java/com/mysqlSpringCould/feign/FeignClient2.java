package com.mysqlSpringCould.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "test",url = "http://localhost:9000")
public interface FeignClient2 {


    @RequestMapping("/eureka/apps/{servicename}")
    String getServiceInfo(@PathVariable("servicename") String servicename);

}
