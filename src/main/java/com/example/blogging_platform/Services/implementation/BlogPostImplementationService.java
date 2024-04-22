package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.Services.interfaces.BlogPostService;
import com.example.blogging_platform.dtos.BlogPostRequest;
import com.example.blogging_platform.dtos.BlogPostResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RequiredArgsConstructor
public class BlogPostImplementationService implements BlogPostService {
    @Override
    public void createBlogPost(BlogPostRequest blogPostRequest) {

    }

    @Override
    public void updateBlogPost(BlogPostRequest blogPostRequest) {

    }

    @Override
    public List<BlogPostResponse> listAllBlogPosts() {
        return null;
    }

    @Override
    public BlogPostResponse getBlogPostByUuid(String uuid) {
        return null;
    }

    @Override
    public BlogPostResponse searchBlogPostByBlogName(String blogPostTitle) {
        return null;
    }
    @Override
    public void delete(String uuid) {

    }
}
