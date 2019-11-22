package com.mysqlSpringCould.feign;

import com.mysqlSpringCould.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FeignClient1Hystrix implements FeignClient1 {
    @Override
    public User getOrder(Long id) {
        User user=new User();
        user.setId(-300L);
        user.setDate(new Date());
        return user;
    }

    @Override
    public User get_user(User user) {
        return user;
    }
}
