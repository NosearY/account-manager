package com.acmebank.accountmanager.model.dto;

import com.acmebank.accountmanager.model.domain.AcmebUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class UserDetailsImpl implements UserDetails {

    private int userId;

    private String username;

    @JsonIgnore
    private String passwordHash;

    private Date createDate;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(int userId, String username, String passwordHash,
                           Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(AcmebUser user) {
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUsername(),
                user.getPasswordHash(),
                null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.passwordHash;
    }

    @Override
    public String getUsername() {
        return this.username;
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
