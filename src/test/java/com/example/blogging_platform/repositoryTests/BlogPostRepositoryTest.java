package com.example.blogging_platform.repositoryTests;

import com.example.blogging_platform.models.BlogPost;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.BlogPostRepository;
import com.example.blogging_platform.repositories.SystemUserRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDateTime;

/**
 * @author Nicholas Nzovia
 * @On 16/06/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@DataJpaTest

 public class BlogPostRepositoryTest {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;
    BlogPost blogPost;
    SystemUser systemUser;

    @BeforeEach
    void setUp() {
        //adding system user
        systemUser = systemUserRepository.findByUuid("Wsl12234");

        blogPost = new BlogPost(
                1l,"blog1234","", LocalDateTime.now(),
                "",LocalDateTime.now(),
                "Java Blog", "Learning Java", "Here Testing Java", systemUser
        );


    }

    //Creating blog post test
    @Test
   public void testCreateABlogPost(){
        blogPost = blogPostRepository.findByUuid("blog1234");
        assertThat(blogPost.getBlogTitle()).isEqualTo("Java Blog");
    }

    @AfterEach
    void tearDown() {
        blogPost = null;
        blogPostRepository.deleteAll();
    }
}
