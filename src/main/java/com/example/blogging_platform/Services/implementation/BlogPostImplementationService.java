package com.example.blogging_platform.Services.implementation;

import com.example.blogging_platform.ExceptionHandling.PostRequestException;
import com.example.blogging_platform.ExceptionHandling.ResourceNotFoundException;
import com.example.blogging_platform.Services.interfaces.BlogPostService;
import com.example.blogging_platform.dtos.BlogPostDeleteResponse;
import com.example.blogging_platform.dtos.BlogPostRequest;
import com.example.blogging_platform.dtos.BlogPostResponse;
import com.example.blogging_platform.models.BlogPost;
import com.example.blogging_platform.repositories.BlogPostRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.blogging_platform.Utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RequiredArgsConstructor
public class BlogPostImplementationService implements BlogPostService {
    private final BlogPostRepository blogPostRepository;
    @Override
    public String createBlogPost(BlogPostRequest blogPostRequest) throws PostRequestException {
        BlogPost blogPost = new BlogPost();
        try{
            blogPost.setUuid(generateUniqueUUIDString());
            blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
            blogPost.setBlogSubTitles(blogPostRequest.getBlogSubTitles());
            blogPost.setBlogDescription(blogPostRequest.getBlogDescription());
            blogPost.setCreatedBy(""); //Todo. Get currently login user uuid -> add util service GetCurrently login user
            blogPost.setCreatedAt(null); //Todo. Create a util function to format date into a specific way that will posted here

            //save to the database
            var savedBlog = blogPostRepository.save(blogPost);

            if(savedBlog == null){
                return "Unable to Create Blog Post";
            }
                return "Blog Created Successfully";
        }catch (Exception exception){
            throw new PostRequestException("Error occurred, unable to add new blog post");
        }

    }

    @Override
    public BlogPost updateBlogPost(BlogPostRequest blogPostRequest, String uuid)
            throws ResourceNotFoundException {
        //check if the post exists.
        try{
            BlogPost blogPost = blogPostRepository.findByUuid(uuid);
            if(blogPost == null){
                throw new ResourceNotFoundException("Blog post with uuid "+uuid+" is not found");
            }
            else{
                blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
                blogPost.setBlogSubTitles(blogPostRequest.getBlogSubTitles());
                blogPost.setBlogDescription(blogPostRequest.getBlogDescription());
                blogPost.setUpdatedBy(""); //Todo. Get currently login user uuid -> add util service GetCurrently login user
                blogPost.setUpdatedAt(null); //todo. getDate from util functions

                blogPostRepository.save(blogPost);
            }
            return  blogPost;

        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }


    }

    @Override
    public List<BlogPost> listAllBlogPosts() throws PostRequestException{
        try{
            return blogPostRepository.findAll();

        }catch (Exception e){
            throw new PostRequestException("Error occurred while retrieving blog posts");
        }
    }

    @Override
    public BlogPost getBlogPostByUuid(String uuid) throws ResourceNotFoundException{
        BlogPost foundBlogPost = blogPostRepository.findByUuid(uuid);
        String message = "Unable to retrieve BlogPost";
        try{
            if(foundBlogPost ==null){
                throw new ResourceNotFoundException(message);
            }else {
                return foundBlogPost;
            }

        }catch (Exception exception){
            throw new ResourceNotFoundException(message);
        }
    }

    @Override
    public BlogPostResponse searchBlogPostByBlogName(String blogPostTitle) {
        return null;
    }
    @Override
    public BlogPostDeleteResponse deleteBlogPostByUUid(String uuid) {
        BlogPost foundBlogPostToDelete = blogPostRepository.findByUuid(uuid);
        BlogPostDeleteResponse response = new BlogPostDeleteResponse();
        response.setDeletionMessage("BlogPost Deleted Successfully");
        String message = "Unable to retrieve BlogPost";
        try{
            if(foundBlogPostToDelete ==null){
                throw new ResourceNotFoundException(message);
            }else {
                blogPostRepository.deleteByUuid(uuid);
                return response;
            }

        }catch (Exception exception){
            throw new ResourceNotFoundException(message);
        }

    }
}
