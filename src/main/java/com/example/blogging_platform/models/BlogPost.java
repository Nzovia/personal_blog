package com.example.blogging_platform.models;

import com.example.blogging_platform.commons.PO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@AllArgsConstructor
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

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    public BlogPost(long l, String blog1234, String s, LocalDateTime now,
                    String s1, LocalDateTime now1, String javaBlog,
                    String learningJava, SystemUser systemUser) {
    }

}
