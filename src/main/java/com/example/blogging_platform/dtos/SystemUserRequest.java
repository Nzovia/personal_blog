package com.example.blogging_platform.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 12/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemUserRequest {
    private String firstName;
    private String lastName;
    private String userEmail;
    private String userPassword;
}
