package com.xh.author;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 @MapperScan(value = {"com.xh.author.mapper" })
public class AuthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 密码编译
        return  new BCryptPasswordEncoder();
    }

}
