package com.sd.myhealthpro.user.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtHelper {

    @Value("${security.jwt.token.secret-key}")
    private static final String JWT_SECRET = "123456789abcdefghijklmnopqrstuvwxyz";
    private static final int MINUTES = 60;

    private static final String EMAIL_CLAIM_KEY ="email";

    public static String generateToken(String email){
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
        return JWT.create()
                .withSubject(email)
                .withClaim(EMAIL_CLAIM_KEY, email)
                .withExpiresAt(getExpirationDate())
                .sign(algorithm);
    }


    private static Date getExpirationDate(){
        var now = Instant.now();
        return Date.from(now.plus(MINUTES,ChronoUnit.MINUTES));
    }
}
