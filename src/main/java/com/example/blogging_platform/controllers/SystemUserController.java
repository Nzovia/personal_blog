package com.example.blogging_platform.controllers;

import com.example.blogging_platform.Services.interfaces.SystemUserService;
import com.example.blogging_platform.dtos.SystemUserRequest;
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
    private SystemUserService systemUserService;
    @PostMapping("add")
    public ResponseEntity CreateSystemUserAccount(@RequestBody SystemUserRequest systemUserRequest){

        return  new ResponseEntity(systemUserService.createUser(systemUserRequest), HttpStatus.CREATED);

    }
}
