package com.example.blogging_platform.controllers;

import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.request.CommentDto;
import com.example.blogging_platform.services.interfaces.CommentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/blog_posts/")
@RequiredArgsConstructor
@Slf4j
public class CommentsController {
    private final CommentsService commentsService;

    @PostMapping("comment")
    public ResponseEntity<StringResponse> addComment(@RequestBody CommentDto commentDto) {
        log.info("Adding comment {}", commentDto.getBlogPostUuid());
        return ResponseEntity.ok(commentsService.addBlogPostComment(commentDto));
    }

    @DeleteMapping("comment/{uuid}")
    public ResponseEntity<StringResponse>deleteComment(@PathVariable String commentId){
        return  ResponseEntity.ok(commentsService.deleteCommentFromBlogPost(commentId));
    }
}
