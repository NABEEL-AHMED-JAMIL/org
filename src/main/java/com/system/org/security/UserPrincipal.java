package com.system.org.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.org.model.User;
import com.system.org.model.view.PermissionListView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPrincipal implements UserDetails {

    private Long id;
    private String email;
    private String password;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;
    private List<PermissionListView> permissionListViews;

    public UserPrincipal(Long id, String email, String password,
         Collection<? extends GrantedAuthority> authorities, List<PermissionListView> permissionListViews) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.permissionListViews = permissionListViews;
    }

    public static UserPrincipal create(User user, List<PermissionListView> permissionListViews) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (PermissionListView permissionListView: permissionListViews) {
            authorities.add(new SimpleGrantedAuthority(permissionListView.getRoleName()));
        }
        return new UserPrincipal(user.getUserId(), user.getUserEmail(),
            user.getUserPassword(), authorities, permissionListViews);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public List<PermissionListView> getPermissionListViews() {
        return permissionListViews;
    }
    public void setPermissionListViews(List<PermissionListView> permissionListViews) {
        this.permissionListViews = permissionListViews;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
