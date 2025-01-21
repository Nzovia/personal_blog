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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.blogging_platform.utils.GenerateRandomUUIDUtil.generateUniqueUUIDString;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentsService {
    private final CommentsRepository commentsRepository;
    private final BlogPostRepository blogPostRepository;

    @Override
    public StringResponse addBlogPostComment(CommentDto commentDto) {
        log.info("Adding Blo {}", commentDto.getBlogPostUuid());

        BlogPost blogPost = blogPostRepository.findByUuid(commentDto.getBlogPostUuid())
                .orElseThrow(() -> new NotFoundException("Blog post not found"));

        // BlogVisitor retrieve it from the current logged in user.
        Comment comment = new Comment();
        comment.setUuid(generateUniqueUUIDString());
        comment.setBlogPost(blogPost);
        comment.setComment(commentDto.getComment());
        comment.setCreatedBy("");
        comment.setCreatedAt(LocalDateTime.now());

        commentsRepository.save(comment);

        return new StringResponse("Comment Added");
    }

    @Override
    public StringResponse deleteCommentFromBlogPost(String commentId) {
        var existing_comment = commentsRepository.findByUuid(commentId)
                .orElseThrow(() -> new NotFoundException("Comment not found"));

        commentsRepository.delete(existing_comment);
        return new StringResponse("Comment Deleted");
    }

    @Override
    public StringResponse updateComment(String commentId, String commentBody) {
        return new StringResponse("Comment Updated");
    }
}
