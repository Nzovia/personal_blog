package com.example.blogging_platform.Services.interfaces;

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
    void createBlogPost(BlogPostRequest blogPostRequest);
    void updateBlogPost(BlogPostRequest blogPostRequest);
    List<BlogPostResponse> listAllBlogPosts();
    BlogPostResponse getBlogPostByUuid(String uuid);
    BlogPostResponse searchBlogPostByBlogName(String blogPostTitle);
    void delete(String uuid);
}
