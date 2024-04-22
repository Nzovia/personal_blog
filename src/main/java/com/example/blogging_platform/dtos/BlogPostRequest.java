package com.example.blogging_platform.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nicholas Nzovia
 * @On 08/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Getter
@Setter
@AllArgsConstructor
public class BlogPostRequest {
    private String blogTitle;
    private String blogSubTitles;
    private String blogDescription;
}
