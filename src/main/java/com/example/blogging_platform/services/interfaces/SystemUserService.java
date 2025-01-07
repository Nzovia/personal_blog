package com.example.blogging_platform.services.interfaces;

import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.response.SuccessResponse;
import com.example.blogging_platform.dtos.request.SystemUserLoginRequest;
import com.example.blogging_platform.dtos.response.SystemUserLoginResponse;
import com.example.blogging_platform.dtos.request.SystemUserRequest;
import com.example.blogging_platform.dtos.response.UserProfileResponse;
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
    UserProfileResponse getSystemUserProfile(String uuid);
    StringResponse assignRolesToAUser(String userId, String roleId);
}
