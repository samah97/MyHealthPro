package com.sd.myhealthpro.common.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JWTCookieHelper {

    public static final String TOKEN_COOKIE_NAME = "token";

    public void addCookie(HttpServletResponse response, String jwt){
        Cookie cookie =initCookie(jwt);
        response.addCookie(cookie);
    }

    private Cookie initCookie(String jwt) {
        Cookie cookie = new Cookie(TOKEN_COOKIE_NAME, jwt);

        return cookie;
    }

}
