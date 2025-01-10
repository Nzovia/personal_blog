package com.example.blogging_platform.dtos.request;

import com.example.blogging_platform.models.BlogPostDiscussion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 08/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
public class BlogPostRequest {
    private String blogTitle;
    private String blogTitleDescription;
    private List<BlogPostDiscussion> blogPostDiscussions;
}
