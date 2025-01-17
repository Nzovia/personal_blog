package com.example.blogging_platform.controllers;

import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.request.CommentDto;
import com.example.blogging_platform.models.Comment;
import com.example.blogging_platform.services.interfaces.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentsController {
    private final CommentsService commentsService;

    public ResponseEntity<StringResponse> addComment(CommentDto commentDto) {
        var response = commentsService.addBlogPostComment(commentDto);
        return ResponseEntity.ok(response);
    }
}
