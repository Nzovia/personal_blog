package com.example.blogging_platform.repository;

import com.example.blogging_platform.models.Role;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.RolesRepository;
import com.example.blogging_platform.repositories.SystemUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Nicholas Nzovia
 * @On 14/06/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@DataJpaTest
public class SystemUserRepositoryTest {
    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private RolesRepository rolesRepository;
    SystemUser systemUser;
    Role role;

    //what happens before execution
    @BeforeEach
    void setUp() {

        role = new Role(1l,"role101","ADMIN");
        rolesRepository.save(role);

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        systemUser = new SystemUser(1l,"Wsl12234","", LocalDateTime.now(),
                "",LocalDateTime.now(),
                "Nicholas","Maundu","NM",
                "nichonzovia@gmail.com","12345",roleSet);
        systemUserRepository.save(systemUser);

    }

    //what happens after execution
    @AfterEach
    void tearDown() {
        systemUser = null;
        role = null;
        systemUserRepository.deleteAll();
    }

    //Test Cases, find User by email {SUCCESS, FAILURE}
    //...success
    @Test
    void testFindSystemUserByEmail(){
        Optional<SystemUser> systemUser1 = systemUserRepository.findByUserEmail("nichonzovia@gmail.com");
        assertThat(systemUser1.isPresent()).isTrue();
        assertThat(systemUser1.get().getFirstName()).isEqualTo(systemUser.getFirstName());
    }

    //...failure
    @Test
    void testFindSystemUserByEmailNotFound(){
        Optional<SystemUser> systemUser1 = systemUserRepository.findByUserEmail("nichonzovia1@gmail.com");
        assertThat(systemUser1.isPresent()).isFalse();
    }
}
