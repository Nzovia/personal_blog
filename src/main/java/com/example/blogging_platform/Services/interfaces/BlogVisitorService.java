package com.example.blogging_platform.Services.interfaces;

import com.example.blogging_platform.dtos.BlogCommentsRequest;
import com.example.blogging_platform.dtos.BlogVisitorRequest;

/**
 * @author Nicholas Nzovia
 * @On 08/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface BlogVisitorService {
    void createAccount(BlogVisitorRequest blogVisitorRequest);
    void subscribeToBlogMailAlerts(String email);
    void addCommentOnABlog(String blog_uuid,
                                   BlogCommentsRequest blogCommentsRequest);


}
