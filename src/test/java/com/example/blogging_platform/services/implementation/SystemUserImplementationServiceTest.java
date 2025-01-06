package com.example.blogging_platform.services.implementation;

import com.example.blogging_platform.dtos.request.SystemUserRequest;
import com.example.blogging_platform.dtos.response.SuccessResponse;
import com.example.blogging_platform.models.Role;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.RolesRepository;
import com.example.blogging_platform.repositories.SystemUserRepository;
import com.example.blogging_platform.services.interfaces.SystemUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SystemUserImplementationServiceTest {
    @Mock
    private SystemUserRepository systemUserRepository;
    private SystemUserService systemUserImplService;
    AutoCloseable autoCloseable;
    SystemUser systemUser;
    SystemUserRequest signUpRequest;
    SuccessResponse successResponse;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);

        var passwordEncoder = mock(PasswordEncoder.class);
        var rolesRepository = mock(RolesRepository.class);
        var authenticationManager = mock(AuthenticationManager.class);

        systemUserImplService = new SystemUserImplementationService(systemUserRepository, passwordEncoder,
                authenticationManager, rolesRepository);


        Role role = new Role(1L, "role101", "ADMIN");

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        // Mocking the behaviour of password encoder
        when(passwordEncoder.encode("12345")).thenReturn("encodedPassword");

        systemUser = new SystemUser(1L, "Wsl12234", "", LocalDateTime.now(),
                "", LocalDateTime.now(),
                "Nicholas", "Maundu", "NM",
                "nichonzovia@gmail.com", "12345", roleSet);

        signUpRequest = new SystemUserRequest(
                "Nicholas",
                "Maundu",
                "nichonzovia@gmail.com",
                "12345678"
        );

        successResponse = new SuccessResponse(
                200,
                "User account Created"
        );

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testSystemUserSignUp() {
        mock(SystemUserRepository.class);

        when(systemUserRepository.save(systemUser)).thenReturn(systemUser);
        assertThat(systemUserImplService.systemUserSignUp(signUpRequest).getSuccessMessage()).isEqualTo(successResponse.getSuccessMessage());
        assertThat(systemUserImplService.systemUserSignUp(signUpRequest).getStatus()).isEqualTo(successResponse.getStatus());

    }

    @Test
    void systemUserLogin() {
    }

    @Test
    void assignRolesToAUser() {
    }

    @Test
    void getSystemUserProfile() {
    }
}