package com.example.blogging_platform.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "blog_post_content")
public class BlogPostDiscussion {
    @Id
    @Column(unique = true, nullable = false)
    private String discussionUuid;
    @Column(name = "blog_sub_title")
    private String blogSubTitles;
    @Column(name = "blog_content")
    @NotBlank(message = "description required")
    private String blogPostContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "blog_post_uuid",
            referencedColumnName = "uuid",
            nullable = false)
    @JsonBackReference
    private BlogPost blogPost;
}
