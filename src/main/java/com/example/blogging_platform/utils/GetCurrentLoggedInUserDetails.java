package com.example.blogging_platform.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class GetCurrentLoggedInUserDetails {
    private GetCurrentLoggedInUserDetails() {
    }

    public static UserDetails getCurrentUser() {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return  (UserDetails) authentication.getPrincipal();
   }

}
