package com.sd.myhealthpro.user.service;

import com.sd.myhealthpro.auth.UserDetailsImpl;
import com.sd.myhealthpro.auth.service.JwtTokenService;
import com.sd.myhealthpro.user.domain.UserInfo;
import com.sd.myhealthpro.auth.dto.request.LoginRequest;
import com.sd.myhealthpro.auth.dto.request.RegisterRequest;
import com.sd.myhealthpro.auth.dto.response.LoginResponse;
import com.sd.myhealthpro.user.entity.UserEntity;
import com.sd.myhealthpro.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean existsByEmail(String email){
        return userRepository.findUserEntityByEmail(email).isPresent();
    }
}
