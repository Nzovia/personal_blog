package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.ExceptionHandling.ResourceTakenException;
import com.example.blogging_platform.Services.interfaces.SystemUserService;
import com.example.blogging_platform.Utils.GenerateRandomUUIDUtil;
import com.example.blogging_platform.dtos.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

import static com.example.blogging_platform.Utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RequiredArgsConstructor
public class SystemUserImplementationService implements SystemUserService {
    private final SystemUserRepository systemUserRepository;
    private  final PasswordEncoder passwordEncoder;

    //Creating User Account.
    @Override
    public SystemUser createUser(SystemUserRequest systemUserRequest) throws ResourceTakenException{
        //throwing exception the email is already taken
        var emailExists = systemUserRepository.existsByUserEmail(systemUserRequest.getUserEmail());
        if(emailExists){
            throw new ResourceTakenException("Email already exists");
        }
        boolean uuidExists = systemUserRepository.existsByUuid(generateUniqueUUIDString());
        if(!uuidExists){
            throw new ResourceTakenException("There is a UUID collision Please re-register");
        }
        SystemUser systemUser = new SystemUser();
        systemUser.setUuid(generateUniqueUUIDString());
        systemUser.setFirstName(systemUserRequest.getFirstName());
        systemUser.setLastName(systemUserRequest.getLastName());
        systemUser.setUserEmail(systemUserRequest.getUserEmail());
        systemUser.setUserPassword(passwordEncoder.encode(systemUserRequest.getUserPassword()));
        systemUser.setCreatedAt(getCurrentLocalDateTime());
        systemUserRepository.save(systemUser);
        return systemUser;
    }

    //Getting User Profile details
    @Override
    public SystemUser getSystemUserProfile(String uuid) {
        SystemUser systemUser = systemUserRepository.findByUuid(uuid);
        return null;
    }

    private LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }
}
