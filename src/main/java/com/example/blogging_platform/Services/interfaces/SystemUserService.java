package com.example.blogging_platform.Services.interfaces;

import com.example.blogging_platform.dtos.SuccessResponse;
import com.example.blogging_platform.dtos.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.SystemUserRequest;
import com.example.blogging_platform.models.SystemUser;
import org.springframework.stereotype.Service;

/**
 * @author Nicholas Nzovia
 * @On 08/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
public interface SystemUserService {
    SuccessResponse systemUserSignUp(SystemUserRequest systemUserRequest);
    SystemUserLoginResponse systemUserLogin(SystemUserLoginRequest systemUserLoginRequest);
    SystemUser getSystemUserProfile(String uuid);
}
