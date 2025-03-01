package com.example.blogging_platform.controllers;

import com.example.blogging_platform.dtos.response.UserProfileResponse;
import com.example.blogging_platform.services.interfaces.SystemUserService;
import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.response.SuccessResponse;
import com.example.blogging_platform.dtos.request.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.response.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.request.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/users/")
public class SystemUserController {
    private  final SystemUserService systemUserService;

    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("sign_up")
    public ResponseEntity<SuccessResponse> createSystemUserAccount(@RequestBody SystemUserRequest systemUserRequest){
        return  new ResponseEntity<>(systemUserService.systemUserSignUp(systemUserRequest), HttpStatus.OK);
    }
    @PostMapping("sign_in")
    public ResponseEntity<SystemUserLoginResponse> systemUserLogin(@Valid @RequestBody SystemUserLoginRequest loginRequest){
        return new ResponseEntity<>(systemUserService.systemUserLogin(loginRequest), HttpStatus.OK);
    }
    @GetMapping("/me/{uuid}")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable String uuid){
        return new ResponseEntity<>(systemUserService.getSystemUserProfile(uuid), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/assign_role")
    public ResponseEntity<StringResponse> assignROlesToTheUser(@RequestParam(name = "userId") String userId,
                                                               @RequestParam(name = "roleId") String roleId){
        return new ResponseEntity<>(systemUserService.assignRolesToAUser(userId, roleId), HttpStatus.OK);
    }

}
