package com.mysqlSpringCould.controller;


import com.mysqlSpringCould.feign.FeignClient1;
import com.mysqlSpringCould.feign.FeignClient2;
import com.mysqlSpringCould.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private FeignClient1 feignClient1;

    @Autowired
    private FeignClient2 feignClient2;


    @GetMapping("/order/{id}")
    public User getOrder(@PathVariable("id") Long id){
        User user=feignClient1.getOrder(id);
        return user;
    }

//    @GetMapping("/get_user")
//    public User get_user(User user){
//        User order=feignClient1.get_user(user);
//        return order;
//    }

    @RequestMapping("/serviceinfo/{name}")
    public String getServiceInfo(@PathVariable String name){
        String message=feignClient2.getServiceInfo(name);
        return message;
    }

}
