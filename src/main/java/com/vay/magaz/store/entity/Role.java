package com.vay.magaz.store.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}
