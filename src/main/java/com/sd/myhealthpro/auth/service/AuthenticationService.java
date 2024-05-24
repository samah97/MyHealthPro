package com.sd.myhealthpro.auth.service;

import com.sd.myhealthpro.auth.UserDetailsImpl;
import com.sd.myhealthpro.auth.dto.request.LoginRequest;
import com.sd.myhealthpro.auth.dto.request.RegisterRequest;
import com.sd.myhealthpro.auth.dto.response.LoginResponse;
import com.sd.myhealthpro.user.domain.UserInfo;
import com.sd.myhealthpro.user.entity.UserEntity;
import com.sd.myhealthpro.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager passwordAuthenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    public UserInfo register(RegisterRequest request){
        UserEntity userEntity = new UserEntity()
                .setEmail(request.email())
                .setPassword(request.password())
                .setFirstName(request.firstName())
                .setLastName(request.lastName())
                .setPassword(doHashPassword(request.password()));

        userEntity =userRepository.save(userEntity);
        return new UserInfo(
                userEntity.getId(),
                userEntity.getFirstName(),userEntity.getLastName(),userEntity.getEmail(),userEntity.getPhoneNumber());
    }

    public String doAuthenticate(LoginRequest loginRequest){
        Authentication authentication = passwordAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.email(),
                loginRequest.password()
        ));
        if(authentication.isAuthenticated()){
            return jwtTokenService.GenerateToken(loginRequest.email());
        }
        throw new UsernameNotFoundException("Authentication Failed!");
    }

    String doHashPassword(String plainPassword){
        return passwordEncoder.encode(plainPassword);
    }

}
