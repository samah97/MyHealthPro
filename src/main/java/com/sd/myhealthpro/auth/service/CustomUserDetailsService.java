package com.sd.myhealthpro.auth.service;

import com.sd.myhealthpro.auth.enums.Authorities;
import com.sd.myhealthpro.auth.UserDetailsImpl;
import com.sd.myhealthpro.user.entity.UserEntity;
import com.sd.myhealthpro.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private static final Set<Authorities> ONLY_USER_AUTHORITY = Set.of(Authorities.ROLE_USER);

    @Transactional(readOnly = true)
    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity =
                userRepository.findUserEntityByEmail(email).orElseThrow(
                        ()-> new UsernameNotFoundException("Invalid Username or Password")
                );
        //TODO: Add Authorities
        return new UserDetailsImpl(userEntity.getEmail(), userEntity.getPassword(), ONLY_USER_AUTHORITY);
    }
}
