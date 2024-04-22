package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {

    BlogPost findByUuid(String uuid);
}
