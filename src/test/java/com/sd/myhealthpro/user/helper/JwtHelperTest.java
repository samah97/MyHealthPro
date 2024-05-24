package com.sd.myhealthpro.user.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtHelperTest {

    @Test
    void generateToken() {
        String email = "samahdaou97@gmail.com";
        String token = JwtHelper.generateToken(email);
        assertNotNull(token);
    }
}