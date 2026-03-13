package com.javawithakash.springbootredis.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {


    @Autowired
    private ProductService productService;

    @Autowired
    private RedisTemplate redisTemplate;



    @Disabled
    @Test
    void getProductById() {

//        redisTemplate.opsForValue().set("discount", "30");
//        Object discount = redisTemplate.opsForValue().get("discount");
//        int a = 1;
//        System.out.println("the discount value is of " + discount);

        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name form redis "+name);
    }
}
