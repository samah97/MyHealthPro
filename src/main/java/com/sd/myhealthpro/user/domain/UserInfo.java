package com.sd.myhealthpro.user.domain;

public record UserInfo (

    Long userId,
    String firstName,
    String lastName,
    String email,
    String phoneNumber
){}
