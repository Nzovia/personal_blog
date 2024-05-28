package com.example.blogging_platform.controllers;

import com.example.blogging_platform.Services.implementation.RoleService;
import com.example.blogging_platform.dtos.RoleDto;
import com.example.blogging_platform.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Nzovia
 * @On 25/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RolesController {
    private final RoleService roleService;

    @PostMapping ()
    public ResponseEntity<Role> addSystemRoles(@RequestBody RoleDto roleDto){
        return new ResponseEntity<>(roleService.createUserRoles(roleDto),HttpStatus.OK);
    }
}
