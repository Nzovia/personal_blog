package com.example.blogging_platform.models;

import com.example.blogging_platform.Commons.PO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_blog_visitors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BlogVisitor extends PO {
    @Column(name = "visitor_email")
    @NotBlank(message = "email is required")
    private String visitorEmail;
    @Column(name = "visitor_password")
    @NotBlank(message = "password is required")
    private String visitorPassword;

    //One visitor many comments
}
