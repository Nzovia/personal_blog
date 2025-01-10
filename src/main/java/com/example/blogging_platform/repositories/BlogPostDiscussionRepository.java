package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.BlogPostDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostDiscussionRepository extends JpaRepository<BlogPostDiscussion, String> {
}
