package com.example.blogging_platform.models;

import com.example.blogging_platform.Commons.PO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_system_users")
@Getter
@Setter
public class SystemUser extends PO {
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "first name is required")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "last name is required")
    private String lastName;
    private String userName;
    @Column(name = "user_email", nullable = false, unique = true)
    @NotBlank(message = "user email is required")
    @Email
    @Size(max = 200)
    private String userEmail;
    @Column(name = "user_password")
    @NotBlank(message = "password is required")
    @Size(min = 8, max = 12)
    private String userPassword;

    public SystemUser() {
    }

    public SystemUser(Long id, String uuid, String createdBy,
                      LocalDateTime createdAt, LocalDateTime updatedBy,
                      LocalDateTime updatedAt, LocalDateTime deletedBy,
                      LocalDateTime deletedAt, String firstName,
                      String lastName, String userName,
                      String userEmail, String userPassword) {
        super(id, uuid, createdBy, createdAt, updatedBy, updatedAt, deletedBy, deletedAt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
