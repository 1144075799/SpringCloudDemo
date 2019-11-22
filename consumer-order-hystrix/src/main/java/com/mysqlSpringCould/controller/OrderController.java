package com.mysqlSpringCould.controller;

import com.mysqlSpringCould.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;  //Spring用于访问rest接口的模板对象

//    private String url="http://localhost:7901/user/";


    @GetMapping("/order/{id}")
    @HystrixCommand(fallbackMethod = "fail",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy",value = "SEMAPHORE")
    })  //"execution.isolation.strategy" 默认不建议大家修改，如果大家遇到问题 在修改 否则不建议
    public User getOrder(@PathVariable Long id){
        //访问提供者，获取数据
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("provider-user1",false);
        String url=instanceInfo.getHomePageUrl();

        User user = restTemplate.getForObject(url+"/user/" + id, User.class);        //通过访问rest获取到json数据，然后转化成User
        return user;
    }

    public User fail(Long id){
        User user=new User();
        user.setId(-100L);
        user.setDate(new Date());
        return user;
    }

}
