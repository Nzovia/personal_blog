package com.example.blogging_platform.models;

import com.example.blogging_platform.commons.PO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_blog_posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPost extends PO {
    @Column(name = "blog_title")
    @NotBlank(message = "title required")
    private String blogTitle;

    @Column(name = "blog_sub_title")
    private String blogSubTitles;
    @Column(name = "blog_body")
    @NotBlank(message = "description required")
    private String blogDescription;

    //OneUser creates many BlogPosts
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_uuid",
            referencedColumnName = "uuid"
    )
    private SystemUser systemUser;

}
