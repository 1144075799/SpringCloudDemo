package com.mysqlSpringCould.controller;

import com.mysqlSpringCould.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {


    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;  //Spring用于访问rest接口的模板对象

//    private String url="http://localhost:7901/user/";


    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable Long id){
        //访问提供者，获取数据
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("provider-user",false);
        String url=instanceInfo.getHomePageUrl();

        User user = restTemplate.getForObject(url+"user/"+ id, User.class);        //通过访问rest获取到json数据，然后转化成User
        return user;
    }

}
