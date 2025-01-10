package com.example.blogging_platform.services.implementation;

import com.example.blogging_platform.exception.PostRequestException;
import com.example.blogging_platform.exception.NotFoundException;
import com.example.blogging_platform.services.interfaces.BlogPostService;
import com.example.blogging_platform.dtos.response.BlogPostDeleteResponse;
import com.example.blogging_platform.dtos.request.BlogPostRequest;
import com.example.blogging_platform.models.BlogPost;
import com.example.blogging_platform.repositories.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.blogging_platform.utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;
import static com.example.blogging_platform.utils.GetCurrentLoggedInUserDetails.getCurrentUser;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@Service
@RequiredArgsConstructor
public class BlogPostImplementationService implements BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Override
    public String createBlogPost(BlogPostRequest blogPostRequest) throws PostRequestException {
        BlogPost blogPost = new BlogPost();
        var userDetails = getCurrentUser();
        try {
            blogPost.setUuid(generateUniqueUUIDString());
            blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
            blogPost.setBlogTitleDescription(blogPostRequest.getBlogTitleDescription());
            blogPost.setCreatedBy(userDetails.getUsername());
            blogPost.setCreatedAt(LocalDateTime.now());

            //save to the database
            blogPostRepository.save(blogPost);

            return "Blog Created Successfully";


        } catch (Exception exception) {
            throw new PostRequestException("Error occurred, unable to add new blog post");
        }
    }

    @Override
    public BlogPost updateBlogPost(BlogPostRequest blogPostRequest, String uuid)
            throws NotFoundException {
        //check if the post exists.
        try {
            BlogPost blogPost = blogPostRepository.findByUuid(uuid);
            if (blogPost == null) {
                throw new NotFoundException("Blog post with uuid " + uuid + " is not found");
            } else {
                blogPost.setBlogTitle(blogPostRequest.getBlogTitle());
                blogPost.setBlogTitleDescription(blogPostRequest.getBlogTitleDescription());
                blogPost.setUpdatedBy(getCurrentUser().getUsername());
                blogPost.setUpdatedAt(LocalDateTime.now());

                blogPostRepository.save(blogPost);
            }
            return blogPost;

        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public Page<BlogPost> listAllBlogPosts(int pageNo, int pageSize) throws PostRequestException {
        try {
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            return blogPostRepository.findAll(pageable);
        } catch (Exception e) {
            throw new PostRequestException("Error occurred while retrieving blog posts");
        }
    }

    @Override
    public BlogPost getBlogPostByUuid(String uuid) throws NotFoundException {
        BlogPost foundBlogPost = blogPostRepository.findByUuid(uuid);
        String message = "Unable to retrieve BlogPost";
        try {
            if (foundBlogPost == null) {
                throw new NotFoundException(message);
            } else {
                return foundBlogPost;
            }

        } catch (Exception exception) {
            throw new NotFoundException(message);
        }
    }

    @Override
    public List<BlogPost> searchBlogPostByBlogName(String searchText) {
        return blogPostRepository.findBlogPostsBySearchText(searchText);
    }

    @Override
    public BlogPostDeleteResponse deleteBlogPostByUUid(String uuid) {
        BlogPost foundBlogPostToDelete = blogPostRepository.findByUuid(uuid);
        BlogPostDeleteResponse response = new BlogPostDeleteResponse();
        response.setDeletionMessage("BlogPost Deleted Successfully");
        String message = "Unable to retrieve BlogPost";
        try {
            if (foundBlogPostToDelete == null) {
                throw new NotFoundException(message);
            } else {
                blogPostRepository.deleteByUuid(uuid);
                return response;
            }

        } catch (Exception exception) {
            throw new NotFoundException(message);
        }

    }
}
