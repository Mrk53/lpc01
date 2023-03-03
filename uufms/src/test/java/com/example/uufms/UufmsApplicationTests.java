package com.example.uufms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UufmsApplicationTests {

    @Test
    void contextLoads() {
        Integer o1 =1,o2 =2;
        System.out.println(o1.compareTo(o2));
    }

}
