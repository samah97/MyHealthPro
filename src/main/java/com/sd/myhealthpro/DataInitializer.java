package com.sd.myhealthpro;

import com.sd.myhealthpro.auth.service.AuthenticationService;
import com.sd.myhealthpro.user.domain.UserInfo;
import com.sd.myhealthpro.auth.dto.request.RegisterRequest;
import com.sd.myhealthpro.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationRunner {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        insertUserSamah();
    }


    private void insertUserSamah() {
        String email = "samdaou97@gmail.com";
        if(userService.existsByEmail(email)){
            return;
        }
        authenticationService.register(
                new RegisterRequest("Samah","Daou",email,"0625208423","samah123456789")
        );
    }
}
