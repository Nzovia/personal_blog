package com.example.blogging_platform.models;

import com.example.blogging_platform.commons.PO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_system_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Size(max = 255)
    private String userPassword;

    public SystemUser(Long id, String uuid,
                      String createdBy, LocalDateTime createdAt,
                      String updatedBy, LocalDateTime updatedAt,
                      String deletedBy, LocalDateTime deletedAt,
                      String firstName, String lastName,
                      String userName, String userEmail,
                      String userPassword, Set<Role> roles) {
        super(id, uuid, createdBy, createdAt, updatedBy,
                updatedAt, deletedBy, deletedAt);
        this.setUuid(uuid);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.roles = roles;
    }

    //ManyToMany relationship system users and roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
