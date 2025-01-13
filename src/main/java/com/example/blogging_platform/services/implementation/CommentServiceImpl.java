package com.example.blogging_platform.services.implementation;

import com.example.blogging_platform.models.Comment;
import com.example.blogging_platform.services.interfaces.CommentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentsService {
    @Override
    public String createComment(String commentBody) {
        return "";
    }

    @Override
    public String deleteComment(String commentId) {
        return "";
    }

    @Override
    public String updateComment(String commentId, String commentBody) {
        return "";
    }

    @Override
    public List<Comment> retrieveAllComments() {
        return List.of();
    }
}
