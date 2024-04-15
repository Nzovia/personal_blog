package com.example.blogging_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.blogging_platform.Utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;

@SpringBootApplication
public class BloggingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingPlatformApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
