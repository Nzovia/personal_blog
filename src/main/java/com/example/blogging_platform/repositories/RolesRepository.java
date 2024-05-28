package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 25/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByUuid(String roleId);
}
