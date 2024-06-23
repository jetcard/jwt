package com.inventarios.bean;

import io.quarkus.security.identity.request.BaseAuthenticationRequest;

public class SessionAuthenticationRequest extends BaseAuthenticationRequest {
    private final String username;

    public SessionAuthenticationRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}