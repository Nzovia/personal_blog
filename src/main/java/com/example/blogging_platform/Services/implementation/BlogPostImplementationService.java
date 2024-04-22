package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.ExceptionHandling.PostRequestException;
import com.example.blogging_platform.Services.interfaces.BlogPostService;
import com.example.blogging_platform.dtos.BlogPostRequest;
import com.example.blogging_platform.dtos.BlogPostResponse;
import com.example.blogging_platform.models.BlogPost;
import com.example.blogging_platform.repositories.BlogPostRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RequiredArgsConstructor
public class BlogPostImplementationService implements BlogPostService {
    private final BlogPostRepository blogPostRepository;
    @Override
    public void createBlogPost(BlogPostRequest blogPostRequest) throws PostRequestException {
        BlogPost blogPost = new BlogPost();
        try{
            blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
            blogPost.setBlogSubTitles(blogPostRequest.getBlogSubTitles());
            blogPost.setBlogDescription(blogPostRequest.getBlogDescription());
            blogPost.setCreatedBy(""); //Todo. Get currently login user uuid -> add util service GetCurrently login user
            blogPost.setCreatedAt(null); //Todo. Create a util function to format date into a specific way that will posted here

            //save to the database
            blogPostRepository.save(blogPost);
        }catch (Exception exception){
            throw new PostRequestException("Error occurred, unable to add new blog post");
        }

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
