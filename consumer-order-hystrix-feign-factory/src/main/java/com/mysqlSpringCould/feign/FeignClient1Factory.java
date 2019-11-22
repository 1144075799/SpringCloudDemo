package com.mysqlSpringCould.feign;

import com.mysqlSpringCould.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FeignClient1Factory implements FallbackFactory<FeignClient1> {
    @Override
    public FeignClient1 create(Throwable throwable) {
        return new FeignClient1() {
            @Override
            public User getOrder(Long id) {
                User user=new User();
                user.setId(-500L);
                user.setDate(new Date());
                return user;
            }

            @Override
            public User get_user(User user) {
                return user;
            }
        };
    }
}
