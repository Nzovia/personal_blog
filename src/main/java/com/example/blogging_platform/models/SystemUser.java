package com.example.blogging_platform.models;

import com.example.blogging_platform.Commons.PO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @NotEmpty(message = "first name is required")
    private String FirstName;
    @Column(name = "last_name")
    @NotEmpty(message = "last name is required")
    private String lastName;
    private String userName;
    @Column(name = "user_email")
    @NotEmpty(message = "user email is required")
    private String userEmail;
    @Column(name = "user_password", length = 8)
    @NotEmpty(message = "password is required")
    private String userPassword;

    //Todo. OneUser to many BlogPosts


}
