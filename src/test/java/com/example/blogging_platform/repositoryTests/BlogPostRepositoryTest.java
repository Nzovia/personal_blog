package com.example.blogging_platform.repositoryTests;

import com.example.blogging_platform.dtos.response.UserProfileResponse;
import com.example.blogging_platform.models.BlogPost;
import com.example.blogging_platform.models.Role;
import com.example.blogging_platform.models.SystemUser;
import com.example.blogging_platform.repositories.BlogPostRepository;
import com.example.blogging_platform.repositories.RolesRepository;
import com.example.blogging_platform.repositories.SystemUserRepository;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertNotNull;

/**
 * @author Nicholas Nzovia
 * @On 16/06/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@DataJpaTest
class BlogPostRepositoryTest {
    @Autowired
    private BlogPostRepository blogPostRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;
    @Autowired
    private RolesRepository rolesRepository;
    BlogPost blogPost;
    SystemUser systemUser;
    UserProfileResponse profile;
    Role role;

    @BeforeEach
    void setUp() {
        systemUser = systemUserRepository.findByUuid("Wsl12234");
        if (systemUser == null) {
            role = new Role(1L,"role101","ADMIN");
            rolesRepository.save(role);

            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);

            systemUser = new SystemUser(1L,"Wsl12234","", LocalDateTime.now(),
                    "",LocalDateTime.now(),
                    "Nicholas","Maundu","NM",
                    "nichonzovia@gmail.com","12345",roleSet);
            systemUserRepository.save(systemUser);
        }

        blogPost = new BlogPost(
                1L, "blog1234", "", LocalDateTime.now(),
                "", LocalDateTime.now(),
                "Java Blog", "Learning Java", systemUser);
        blogPostRepository.save(blogPost);
    }



    @AfterEach
    void tearDown() {
        blogPost = null;
        blogPostRepository.deleteAll();
    }


    // Success Test Case
    @Test
    void testBlogPostFindByUuid() {
        BlogPost blogPost1 = blogPostRepository.findByUuid("blog1234");
        assertThat(blogPost1.getBlogTitle()).isEqualTo(blogPost.getBlogTitle());
    }

    //Failure Test Case
    @Test
    void testblogPostFindByUuidFailed(){
        BlogPost blogPost1 = blogPostRepository.findByUuid("blog12");
        assertThat(blogPost1 == null).isTrue();
    }




}
