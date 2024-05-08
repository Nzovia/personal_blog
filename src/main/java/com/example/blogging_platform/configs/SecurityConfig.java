package com.example.blogging_platform.configs;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Nicholas Nzovia
 * @On 07/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Configuration
public class WebSecurityConfig{
    @Resource(name = "userService")
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests((auth)-> auth
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(withDefaults());
        return httpSecurity.build();
    }
}
