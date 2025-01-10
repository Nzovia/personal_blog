package com.example.blogging_platform.models;

import com.example.blogging_platform.commons.PO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 06/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Entity
@Table(name = "tb_blog_posts")
@Getter
@Setter
@NoArgsConstructor
public class BlogPost extends PO {
    @Column(name = "blog_title")
    @NotBlank(message = "title required")
    private String blogTitle;

    @Column(name = "blog_description")
    private String blogTitleDescription;
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BlogPostDiscussion> blogPostDiscussions = new ArrayList<>();

    //OneUser creates many BlogPosts
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_uuid",
            referencedColumnName = "uuid"
    )
    private SystemUser systemUser;

    public BlogPost(Long id, String uuid, String createdBy, LocalDateTime createdAt,
                    String updatedBy, LocalDateTime updatedAt, String blogTitle, String blogTitleDescription,
                     SystemUser systemUser) {
        super(id, uuid, createdBy, createdAt, updatedBy, updatedAt);
        this.blogTitle = blogTitle;
        this.blogTitleDescription = blogTitleDescription;
        this.systemUser = systemUser;
    }
}
