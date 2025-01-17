package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.BlogVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogVisitorRepository extends JpaRepository<BlogVisitor,Long> {
    Optional<BlogVisitor> findBlogVisitorByUuid(String authorId);
}
