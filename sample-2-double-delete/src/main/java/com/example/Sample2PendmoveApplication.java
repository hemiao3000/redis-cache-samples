package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories(basePackages = "com.example.redis")
public class Sample2PendmoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sample2PendmoveApplication.class, args);
    }

}
