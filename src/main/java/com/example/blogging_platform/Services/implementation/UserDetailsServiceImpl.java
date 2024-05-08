package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SystemUserRepository systemUserRepository;
    @Override
    public UserDetails loadUserByUsername(String user_email) {
        SystemUser systemUser = systemUserRepository.findByEmail(user_email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));

        var userDetails = User.builder()
                .username(systemUser.getUserEmail())
                .password(systemUser.getUserPassword())
                .build();
        return userDetails;
    }
}
