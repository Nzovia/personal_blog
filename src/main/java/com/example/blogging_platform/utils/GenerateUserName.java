package com.example.blogging_platform.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateUserName {
    private GenerateUserName() {
    }

    public static String generateUserName(String firstName, String lastName) {
        var username = firstName.charAt(0)+lastName;
        log.info(username);
        return username;

    }
}
