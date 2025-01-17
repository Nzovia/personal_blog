package com.example.blogging_platform.services.implementation;

import com.example.blogging_platform.commons.StringResponse;
import com.example.blogging_platform.dtos.request.CommentDto;
import com.example.blogging_platform.exception.NotFoundException;
import com.example.blogging_platform.models.BlogPost;
import com.example.blogging_platform.models.Comment;
import com.example.blogging_platform.repositories.BlogPostRepository;
import com.example.blogging_platform.repositories.CommentsRepository;
import com.example.blogging_platform.services.interfaces.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentsService {
    private final CommentsRepository commentsRepository;
    private final BlogPostRepository blogPostRepository;

    @Override
    public StringResponse addBlogPostComment(CommentDto commentBody) {

        BlogPost blogPost = blogPostRepository.findByUuid(commentBody.getBlogPostId())
                .orElseThrow(() -> new NotFoundException("Blog post not found"));

        // BlogVisitor retrieve it from the current logged in user.
        Comment comment = Comment.builder()
                .blogPost(blogPost)
                .comment(commentBody.getComment())
                .commentAuthor("")
                .build();

        commentsRepository.save(comment);

        return new StringResponse("Comment Added");
    }

    @Override
    public String deleteCommentFromBlogPost(String commentId) {
        return "";
    }

    @Override
    public String updateComment(String commentId, String commentBody) {
        return "";
    }

    @Override
    public List<Comment> retrieveAllBlogPostComments() {
        return List.of();
    }
}
