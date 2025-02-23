package com.preworkspringredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PreworkSpringRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreworkSpringRedisApplication.class, args);
    }

}
