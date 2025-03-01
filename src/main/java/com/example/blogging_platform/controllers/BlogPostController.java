package com.example.blogging_platform.controllers;

import com.example.blogging_platform.services.interfaces.BlogPostService;
import com.example.blogging_platform.dtos.request.BlogPostRequest;
import com.example.blogging_platform.models.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 23/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("api/v1/blog_posts/")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;
    @PostMapping("add")
    public ResponseEntity<String> addBlogPost(@RequestBody BlogPostRequest request){
        var blogCreated = blogPostService.createBlogPost(request);
        return new ResponseEntity<>(blogCreated,HttpStatus.CREATED);
    }
    @GetMapping("search")
    public ResponseEntity<List<BlogPost>>
    searchBlogPosts(@RequestParam String searchText){
        List<BlogPost> foundBlogPosts = blogPostService.searchBlogPostByBlogName(searchText);
        if(!foundBlogPosts.isEmpty()){
            return ResponseEntity.ok(foundBlogPosts);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("edit/{uuid}")
    public ResponseEntity<Optional<BlogPost>> updateBlogPostTitleOrDescription(
            @PathVariable String uuid, @RequestBody BlogPostRequest blogPostRequest){
       var updateBlogPost =  blogPostService.updateBlogPost(blogPostRequest,uuid);
       return  ResponseEntity.ok(updateBlogPost);
    }
    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<String> deleteBlogPostByUuid(@PathVariable String uuid){
        var deleteResponse = blogPostService.deleteBlogPostByUUid(uuid);
        return ResponseEntity.ok(deleteResponse.defaultDeletionMessage());
    }
    @GetMapping("all")
    public ResponseEntity<Page<BlogPost>>  getAllBlogPosts(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<BlogPost> allBlogPosts = blogPostService.listAllBlogPosts(pageNo,pageSize);
        return ResponseEntity.ok(allBlogPosts);
    }
    @GetMapping("one/{uuid}")
    public ResponseEntity<Optional<BlogPost>> getOneBlogPost(@PathVariable String uuid){
        var blogPost = blogPostService.getBlogPostByUuid(uuid);
        return ResponseEntity.ok(blogPost);
    }

    //Todo. share api, to generate a link and share via email.
}
