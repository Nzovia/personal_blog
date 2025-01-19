package com.example.blogging_platform.models;

import com.example.blogging_platform.commons.PO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@Entity
@Table(name = "tb_comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comment extends PO {
    @Column(name = "comment_body")
    @NotBlank(message = "commentBody is required")
    private String comment;

    //many comments are associated to one BlogPost
    @ManyToOne
    @JoinColumn(
            name = "blog_uuid",
            referencedColumnName = "uuid"
    )
    @JsonBackReference
    private BlogPost blogPost;
}
