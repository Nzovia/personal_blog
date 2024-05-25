package com.example.blogging_platform.Utils;

import com.example.blogging_platform.models.Role;
import com.example.blogging_platform.models.SystemUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 24/05/2024
 * @Contact: itsdevelopernic22@gmail.com
 *
 * Custom implementation of UserDetails used for rep user details
 * and roles(authorities) for both auth and autho...
 */

public class CustomUserDetails extends SystemUser implements UserDetails {
    private String username;
    private String password;
    Collection<? extends GrantedAuthority> authorities;

    public  CustomUserDetails(SystemUser byUserName){
        this.username = byUserName.getUserEmail();
        this.password = byUserName.getUserPassword();

        //retrieving user roles.
        List<GrantedAuthority> auths = new ArrayList<>();
        for(Role role: byUserName.getRoles()){
            auths.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase()));
        }
        this.authorities = auths;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
