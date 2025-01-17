package com.example.blogging_platform.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {
    private String blogPostId;
    private String comment;
    //private String authorId; //get currently signed in user
}
