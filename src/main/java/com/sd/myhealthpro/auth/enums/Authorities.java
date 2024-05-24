package com.sd.myhealthpro.auth.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authorities implements GrantedAuthority {
    ROLE_USER(Roles.USER.toGrantedAuthority());

    private final GrantedAuthority grantedAuthority;

    Authorities(GrantedAuthority grantedAuthority) {
        this.grantedAuthority = grantedAuthority;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
