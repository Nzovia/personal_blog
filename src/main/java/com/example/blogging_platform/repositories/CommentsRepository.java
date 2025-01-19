package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 05/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@Repository
public interface CommentsRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findByUuid(String commentId);
}
