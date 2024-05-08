package com.example.blogging_platform.configs;

import com.example.blogging_platform.Services.implementation.SystemUserImplementationService;
import com.example.blogging_platform.Services.implementation.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author Nicholas Nzovia
 * @On 07/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final PasswordEncoderService passwordEncoder;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(PasswordEncoderService passwordEncoder, UserDetailsServiceImpl userDetailsService) {
        this.passwordEncoder = passwordEncoder;

        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
        httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((auth) -> auth
                        //our public endpoints
                        .requestMatchers(HttpMethod.POST, "/api/auth/signup/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/authentication-docs/**").permitAll()
                        //private endpoints below
                        .anyRequest()
                        .authenticated()
                )
                .authenticationManager(authenticationManager);
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder.passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
