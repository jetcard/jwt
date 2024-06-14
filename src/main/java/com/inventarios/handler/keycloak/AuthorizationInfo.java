package com.inventarios.handler.keycloak;

import java.util.List;

public class AuthorizationInfo {
    private String userId;
    private List<String> roles;

    public AuthorizationInfo(String userId, List<String> roles) {
        this.userId = userId;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public boolean isAdmin() {
        return roles.contains("admin");
    }
}