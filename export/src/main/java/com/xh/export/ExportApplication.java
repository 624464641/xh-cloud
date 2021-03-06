package com.xh.export;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ExportApplication {



    public static void main(String[] args) {
        SpringApplication.run(ExportApplication.class, args);
    }

}
