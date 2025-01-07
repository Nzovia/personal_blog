package com.example.blogging_platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class BloggingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingPlatformApplication.class, args);
        log.info(LocalDateTime.now().toString());
    }
}
