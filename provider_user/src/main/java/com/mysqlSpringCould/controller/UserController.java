package com.mysqlSpringCould.controller;


import com.mysqlSpringCould.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {



    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return new User(id);
    }

//    @GetMapping("/getInfo")
//    public String info(){
//        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("provider_user",false);
//        return instanceInfo.getHomePageUrl();
//    }

    @GetMapping("/get-user")
    public User getUser(User user){
        return user;        //相当于我们传递一个复杂的参数会被封装成user对象，然后我们将封装的对象返回，也就是你传递什么我返回什么
    }

}
