package com.mysqlSpringCould.feign;

import com.mysqlSpringCould.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-user1",fallbackFactory = FeignClient1Factory.class)      //提供者名字
public interface FeignClient1 {

    //@GetMapping("/user/{id}")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
//    @RequestLine("GET /user/{id}")          //这个一个组合注解，第一个是请求方式，第二个是参数，用空格分隔
    User getOrder(@PathVariable("id") Long id);

//    @RequestLine("GET /get-user")
    @RequestMapping(value = "/get-user",method = RequestMethod.GET)
    User get_user(User user);   //如果你传递是复杂参数，那么 feign 不管你配置的是什么请求方式 都会以post方式请求

}
