package com.example.blogging_platform.services.implementation;

import com.example.blogging_platform.dtos.response.UserProfileResponse;
import com.example.blogging_platform.exception.NotFoundException;
import com.example.blogging_platform.exception.ResourceTakenException;
import com.example.blogging_platform.jwt_security.JwtService;
import com.example.blogging_platform.services.interfaces.SystemUserService;

import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.response.SuccessResponse;
import com.example.blogging_platform.dtos.request.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.response.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.request.SystemUserRequest;
import com.example.blogging_platform.models.Role;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.RolesRepository;
import com.example.blogging_platform.repositories.SystemUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.Optional;

import static com.example.blogging_platform.utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;
import static com.example.blogging_platform.utils.GenerateUserName.generateUserName;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
public class SystemUserImplementationService implements SystemUserService {
    private final SystemUserRepository systemUserRepository;
    private  final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RolesRepository rolesRepository;

    public SystemUserImplementationService(SystemUserRepository systemUserRepository,
                                           PasswordEncoder passwordEncoder,
                                           AuthenticationManager authenticationManager,
                                           RolesRepository rolesRepository) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.rolesRepository = rolesRepository;
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
           systemUser.setUserName(generateUserName(systemUserRequest.getFirstName(),systemUserRequest.getLastName()));
           systemUser.setUserPassword(passwordEncoder.encode(systemUserRequest.getUserPassword()));
           systemUser.setCreatedAt(getCurrentLocalDateTime());
           systemUserRepository.save(systemUser);
           return new SuccessResponse(200,"User account Created");
       }catch (Exception e){
           throw new ResourceTakenException(e.getMessage());
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

    @Override
    public StringResponse assignRolesToAUser( String userId,String roleId) {
          Optional<SystemUser> systemUserOptional = Optional.ofNullable(systemUserRepository.findByUuid(userId));
          Optional<Role> roleOptional = rolesRepository.findByUuid(roleId);

          if(systemUserOptional.isPresent() && roleOptional.isPresent()){
              SystemUser user = systemUserOptional.get();
              Role role =roleOptional.get();
              user.getRoles().add(role);
              systemUserRepository.save(user);
              log.info("Testing Role {}", role.getRoleName());
              return new StringResponse("Role Assigned");

          }else{
              throw new NotFoundException("User or Role not found");
          }
      }


    //Getting User Profile details
    @Override
    public UserProfileResponse getSystemUserProfile(String uuid) {
        UserProfileResponse profile = new UserProfileResponse();
        SystemUser user =  systemUserRepository.findByUuid(uuid);
        if(user != null){
            profile.setFirstName(user.getFirstName());
            profile.setLastName(user.getLastName());
            profile.setUsername(user.getUserName());
            profile.setEmail(user.getUserEmail());
        }

        return profile;
    }

    private LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }
}
