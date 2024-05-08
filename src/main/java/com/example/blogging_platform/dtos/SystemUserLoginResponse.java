package com.example.blogging_platform.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Nicholas Nzovia
 * @On 08/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
public class SystemUserLoginResponse {
    private String email;
    private String jwtToken;


}
