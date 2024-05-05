package com.example.blogging_platform.controllers;

import com.example.blogging_platform.Services.interfaces.BlogPostService;
import com.example.blogging_platform.dtos.BlogPostDeleteResponse;
import com.example.blogging_platform.dtos.BlogPostRequest;
import com.example.blogging_platform.models.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Nzovia
 * @On 23/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/blog_posts")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @PostMapping("add")
    private ResponseEntity<String> addBlogPost(@RequestBody BlogPostRequest request){
        var blogCreated = blogPostService.createBlogPost(request);
        return new ResponseEntity<>(blogCreated,HttpStatus.CREATED);
    }

    //Todo. Search blog by title
    @PutMapping("edit/{uuid}")
    private ResponseEntity<BlogPost> updateBlogPostTitleOrDescription(
            @PathVariable String uuid, @RequestBody BlogPostRequest blogPostRequest){
       var updateBlogPost =  blogPostService.updateBlogPost(blogPostRequest,uuid);
       return new ResponseEntity<>(updateBlogPost,HttpStatus.OK);

    }
    @DeleteMapping("delete/{uuid}")
    private ResponseEntity<String> deleteBlogPostByUuid(@PathVariable String uuid){
        var deleteResponse = blogPostService.deleteBlogPostByUUid(uuid);
        return  new ResponseEntity<>(deleteResponse.defaultDeletionMessage(), HttpStatus.OK);
    }
    //Todo. share api, to generate a link and share.
}
