package com.example.blogging_platform.Services.interfaces;

import com.example.blogging_platform.dtos.BlogPostDeleteResponse;
import com.example.blogging_platform.dtos.BlogPostRequest;
import com.example.blogging_platform.models.BlogPost;
import org.springframework.data.domain.Page;
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
    Page<BlogPost> listAllBlogPosts(int pageNo,int pageSize);
    BlogPost getBlogPostByUuid(String uuid);
    List<BlogPost> searchBlogPostByBlogName(String searchText);
    BlogPostDeleteResponse deleteBlogPostByUUid(String uuid);
}
