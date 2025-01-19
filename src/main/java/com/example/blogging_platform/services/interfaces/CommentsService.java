package com.example.blogging_platform.services.interfaces;

import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.request.CommentDto;
import com.example.blogging_platform.models.Comment;

import java.util.List;

public interface CommentsService {
    public StringResponse addBlogPostComment(CommentDto commentBody);
    public StringResponse deleteCommentFromBlogPost(String commentId);
    public StringResponse updateComment(String commentId, String commentBody);
    public List<Comment> retrieveAllBlogPostComments();
}
