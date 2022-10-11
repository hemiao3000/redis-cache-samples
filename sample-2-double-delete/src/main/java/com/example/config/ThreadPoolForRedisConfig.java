package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolForRedisConfig {

    @Bean
    public ScheduledExecutorService threadPoolExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
