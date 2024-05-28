package com.example.blogging_platform.controllers;

import com.example.blogging_platform.Services.interfaces.SystemUserService;
import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.SuccessResponse;
import com.example.blogging_platform.dtos.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/users/")
public class SystemUserController {
    private  SystemUserService systemUserService;

    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PostMapping("sign_up")
    public ResponseEntity<SuccessResponse> CreateSystemUserAccount(@RequestBody SystemUserRequest systemUserRequest){
        return  new ResponseEntity<>(systemUserService.systemUserSignUp(systemUserRequest), HttpStatus.OK);
    }
    @PostMapping("sign_in")
    public ResponseEntity<SystemUserLoginResponse> SystemUserLogin(@Valid @RequestBody SystemUserLoginRequest loginRequest){
        return new ResponseEntity<>(systemUserService.systemUserLogin(loginRequest), HttpStatus.OK);
    }
    @GetMapping("/me/{uuid}")
    public ResponseEntity<SystemUser> getUserProfile(@PathVariable String uuid){
        return new ResponseEntity<>(systemUserService.getSystemUserProfile(uuid), HttpStatus.OK);
    }
    @PostMapping("/assign_role")
    public ResponseEntity<StringResponse> assignROlesToTheUser(@RequestParam(name = "userId") String userId,
                                                               @RequestParam(name = "roleId") String roleId){
        return new ResponseEntity<>(systemUserService.assignRolesToAUser(userId, roleId), HttpStatus.OK);
    }

}
