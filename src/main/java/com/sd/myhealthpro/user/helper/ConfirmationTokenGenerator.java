package com.sd.myhealthpro.user.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfirmationTokenGenerator {

    public static String generateToken(){
        return UUID.randomUUID().toString();
    }

}
