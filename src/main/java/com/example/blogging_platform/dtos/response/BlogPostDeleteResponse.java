package com.example.blogging_platform.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 22/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogPostDeleteResponse {
    private String deletionMessage;
     public String defaultDeletionMessage(){
        deletionMessage = "deletion successful";
        return deletionMessage;
    }
}
