package com.sd.myhealthpro.auth.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Roles {
    USER;

    private final static Map<Roles, GrantedAuthority> AUTHORITY_MAP = Arrays.stream(Roles.values())
            .collect(Collectors.toMap(Function.identity(), i-> new SimpleGrantedAuthority("ROLE_"+i.name())));

    public GrantedAuthority toGrantedAuthority(){
        return AUTHORITY_MAP.get(this);
    }


}
