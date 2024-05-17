package com.example.blogging_platform.controllers;

import com.example.blogging_platform.Services.interfaces.SystemUserService;
import com.example.blogging_platform.dtos.SuccessResponse;
import com.example.blogging_platform.dtos.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/users/")
@RequiredArgsConstructor
public class SystemUserController {
    private final SystemUserService systemUserService;
    @PostMapping("sign_up")
    public ResponseEntity<SuccessResponse> CreateSystemUserAccount(@RequestBody SystemUserRequest systemUserRequest){

        return  new ResponseEntity<>(systemUserService.systemUserSignUp(systemUserRequest), HttpStatus.CREATED);

    }
    @PostMapping("sign_in")
    public ResponseEntity<SystemUserLoginResponse> SystemUserLogin(@Valid @RequestBody SystemUserLoginRequest loginRequest){
        return new ResponseEntity<>(systemUserService.systemUserLogin(loginRequest), HttpStatus.OK);
    }

}
