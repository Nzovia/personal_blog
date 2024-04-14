package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.Services.interfaces.SystemUserService;
import com.example.blogging_platform.dtos.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.SystemUserRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RequiredArgsConstructor
public class SystemUserImplementationService implements SystemUserService {
    private final SystemUserRepository systemUserRepository;
    @Override
    public SystemUser createUser(SystemUserRequest systemUserRequest) {
        SystemUser systemUser = new SystemUser();
        systemUser.builder()
                .firstName(systemUserRequest.getFirstName())
                .lastName(systemUserRequest.getLastName())
                .userEmail(systemUserRequest.getUserEmail())
                .userPassword(systemUserRequest.getUserPassword())
                .build();
        systemUserRepository.save(systemUser);
        return systemUser;
    }
}
