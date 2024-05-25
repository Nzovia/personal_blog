package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.ExceptionHandling.NotFoundException;
import com.example.blogging_platform.ExceptionHandling.ResourceTakenException;
import com.example.blogging_platform.Services.interfaces.SystemUserService;
import com.example.blogging_platform.dtos.SuccessResponse;
import com.example.blogging_platform.dtos.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.SystemUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.blogging_platform.Utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
public class SystemUserImplementationService implements SystemUserService {
    private final SystemUserRepository systemUserRepository;
    private  final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public SystemUserImplementationService(SystemUserRepository systemUserRepository,
                                           PasswordEncoder passwordEncoder,
                                           AuthenticationManager authenticationManager) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    //Creating User Account.
    @Override
    public SuccessResponse systemUserSignUp(SystemUserRequest systemUserRequest) throws ResourceTakenException{
       try{
           //throwing exception the email is already taken
           var emailExists = systemUserRepository.existsByUserEmail(systemUserRequest.getUserEmail());
           if(emailExists){
               throw new ResourceTakenException("Email already exists");
           }
           boolean uuidExists = systemUserRepository.existsByUuid(generateUniqueUUIDString());
           if(uuidExists){
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
           return new SuccessResponse(200,"User account Created");
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
    }

    //Login service
    @Override
    public SystemUserLoginResponse systemUserLogin(SystemUserLoginRequest systemUserLoginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(systemUserLoginRequest.getEmail(),
                        systemUserLoginRequest.getPassword())
        );
        if(authentication.isAuthenticated()){
            String jwtToken = JwtService.generateToken(systemUserLoginRequest.getEmail());
            String message = "Authentication Successful";
            return new SystemUserLoginResponse(systemUserLoginRequest.getEmail(),message,jwtToken);
        }else{
            throw new NotFoundException("user details not valid");
        }

    }
    //Todo. Assign Roles to a User

    //Getting User Profile details
    @Override
    public SystemUser getSystemUserProfile(String uuid) {
        return systemUserRepository.findByUuid(uuid);
    }

    private LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }
}
