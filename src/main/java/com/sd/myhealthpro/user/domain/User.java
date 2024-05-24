package com.sd.myhealthpro.user.domain;

public record User(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
