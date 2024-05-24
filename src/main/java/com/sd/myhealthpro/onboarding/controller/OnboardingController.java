package com.sd.myhealthpro.onboarding.controller;

import com.sd.myhealthpro.onboarding.dto.request.OnboardingRequest;
import com.sd.myhealthpro.onboarding.dto.request.PatientOnboardingRequest;
import com.sd.myhealthpro.onboarding.dto.request.ProfessionalOnboardingRequest;
import com.sd.myhealthpro.onboarding.exception.UnsupportedUserTypeException;
import com.sd.myhealthpro.onboarding.service.patient.PatientOnboardingService;
import com.sd.myhealthpro.onboarding.service.professional.ProfessionalOnboardingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sd.myhealthpro.onboarding.enums.USER_TYPE.PATIENT;

@RequiredArgsConstructor
@RequestMapping("onboarding")
@RestController
public class OnboardingController {

    private final ProfessionalOnboardingService professionalOnboardingService;
    private final PatientOnboardingService patientOnboardingService;

    @PostMapping("")
    public  ResponseEntity<Void> onboarding(@RequestBody @Valid OnboardingRequest request){
        switch (request) {
            case PatientOnboardingRequest patientOnboardingRequest ->
                    patientOnboardingService.processOnboarding(patientOnboardingRequest);
            case ProfessionalOnboardingRequest professionalOnboardingRequest ->
                    professionalOnboardingService.processOnboarding(professionalOnboardingRequest);
            default -> throw new UnsupportedUserTypeException();
        }
        return ResponseEntity.ok().build();
    }

}
