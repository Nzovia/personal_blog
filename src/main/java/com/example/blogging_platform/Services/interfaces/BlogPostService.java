package com.example.blogging_platform.Services.interfaces;

import com.example.blogging_platform.dtos.BlogPostDeleteResponse;
import com.example.blogging_platform.dtos.BlogPostRequest;
import com.example.blogging_platform.dtos.BlogPostResponse;
import com.example.blogging_platform.models.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 08/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
public interface BlogPostService {
    String createBlogPost(BlogPostRequest blogPostRequest);
    BlogPost updateBlogPost(BlogPostRequest blogPostRequest, String uuid);
    List<BlogPost> listAllBlogPosts();
    BlogPost getBlogPostByUuid(String uuid);
    BlogPostResponse searchBlogPostByBlogName(String blogPostTitle);
    BlogPostDeleteResponse deleteBlogPostByUUid(String uuid);
}
