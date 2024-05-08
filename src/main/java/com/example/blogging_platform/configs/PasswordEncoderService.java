package com.example.blogging_platform.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Nicholas Nzovia
 * @On 08/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@Configuration
public class PasswordEncoderService {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
