package com.example.blogging_platform.repositories;

import com.example.blogging_platform.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {

   BlogPost findByUuid(String uuid);

    void deleteByUuid(String uuid);

    @Query(
         "SELECT b FROM BlogPost  b WHERE LOWER(b.blogTitle)" +
                 " LIKE LOWER(CONCAT('%',:searchText,'%')) OR" +
                 " LOWER(b.blogTitle) LIKE LOWER(CONCAT('%',:searchText,'%'))"
    )
    List<BlogPost> findBlogPostsBySearchText(@Param("searchText") String searchText);
}
