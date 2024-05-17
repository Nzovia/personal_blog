package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.ExceptionHandling.NotFoundException;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Nicholas Nzovia
 * @On 08/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 *
 * Class involved in generating logic for loading userDetails by userName
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepository systemUserRepository;
    @Override
    public UserDetails loadUserByUsername(String user_email) {
        SystemUser systemUser = systemUserRepository.findByUserEmail(user_email)
                .orElseThrow(() -> new NotFoundException("Email not found"));

        var userDetails = User.builder()
                .username(systemUser.getUserEmail())
                .password(systemUser.getUserPassword())
                .build();
        return userDetails;
    }
}