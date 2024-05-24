package com.sd.myhealthpro.auth.controller;

import com.sd.myhealthpro.auth.dto.request.LoginRequest;
import com.sd.myhealthpro.auth.dto.request.RegisterRequest;
import com.sd.myhealthpro.auth.service.AuthenticationService;
import com.sd.myhealthpro.common.cookie.JWTCookieHelper;
import com.sd.myhealthpro.user.domain.UserInfo;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("auth")
@RestController
public class AuthController {

    private final AuthenticationService authenticationService;
    private final JWTCookieHelper jwtCookieHelper;

    @PostMapping("login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRequest request, HttpServletResponse response){
        String jwtToken = authenticationService.doAuthenticate(request);
        jwtCookieHelper.addCookie(response,jwtToken);
        return ResponseEntity.ok().build();
    }

    @PostMapping("register")
    public ResponseEntity<UserInfo> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authenticationService.register(request));
    }

}
