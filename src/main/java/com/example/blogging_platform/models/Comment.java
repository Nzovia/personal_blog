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
@Table(name = "Comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment extends PO {
    @Column(name = "comment_body")
    @NotBlank(message = "commentBody is required")
    private String commentBody;

    //Todo. OneToOne relationship with blogVisitor
}
