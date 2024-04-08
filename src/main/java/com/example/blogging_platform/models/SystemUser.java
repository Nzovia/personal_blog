package com.example.blogging_platform.models;

import com.example.blogging_platform.Commons.PO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "system_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser extends PO {
    @Column(name = "first_name")
    @NotBlank(message = "first name is required")
    private String FirstName;
    @Column(name = "last_name")
    @NotBlank(message = "last name is required")
    private String lastName;
    private String userName;
    @Column(name = "user_email")
    @NotBlank(message = "user email is required")
    private String userEmail;
    @Column(name = "user_password", length = 8)
    @NotBlank(message = "password is required")
    private String userPassword;

    //Todo. OneUser to many BlogPosts


}
