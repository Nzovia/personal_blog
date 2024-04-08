package com.example.blogging_platform.Services;

import com.example.blogging_platform.dtos.BlogPostRequest;
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
    private void delete(String uuid){

    }
    private void createBlogPost(BlogPostRequest blogPostRequest){

    }
    private void updateBlogPost(BlogPostRequest blogPostRequest){

    }
    private List<BlogPost> listAllBlogPosts(){
        return null;
    }

    private BlogPost getBlogPostByUuid(String uuid){
        return  null;
    }
}
