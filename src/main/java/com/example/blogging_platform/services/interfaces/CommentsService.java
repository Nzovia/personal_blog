package com.example.blogging_platform.services.interfaces;

import com.example.blogging_platform.models.Comment;

import java.util.List;

public interface CommentsService {
    public String createComment(String commentBody);
    public String deleteComment(String commentId);
    public String updateComment(String commentId, String commentBody);
    public List<Comment> retrieveAllComments();
}
