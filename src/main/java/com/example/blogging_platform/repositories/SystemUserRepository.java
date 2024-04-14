package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nicholas Nzovia
 * @On 14/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

public interface SystemUserRepository extends JpaRepository<SystemUser,Long> {
}
