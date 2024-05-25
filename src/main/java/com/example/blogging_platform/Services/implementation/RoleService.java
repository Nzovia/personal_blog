package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.dtos.RoleDto;
import com.example.blogging_platform.models.Role;
import com.example.blogging_platform.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.example.blogging_platform.Utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;

/**
 * @author Nicholas Nzovia
 * @On 25/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RolesRepository rolesRepository;
    public  Role createUserRoles(RoleDto roleDto){
        var newRole = new Role();
        newRole.setUuid(generateUniqueUUIDString());
        newRole.setRoleName(roleDto.getRoleName());
        rolesRepository.save(newRole);
        return newRole;
    }

}
