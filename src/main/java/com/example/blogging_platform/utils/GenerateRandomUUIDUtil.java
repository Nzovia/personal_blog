package com.example.blogging_platform.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

/**
 * @author Nicholas Nzovia
 * @On 15/04/2024
 * @Contact: itsdevelopernic22@gmail.com
 */

@Slf4j
public class GenerateRandomUUIDUtil {
    private GenerateRandomUUIDUtil() {
    }

    public static String generateUniqueUUIDString(){
        return RandomStringUtils.randomAlphanumeric(12).toLowerCase(Locale.ROOT);
    }

}
