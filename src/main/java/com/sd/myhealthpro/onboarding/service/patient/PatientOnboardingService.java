package com.sd.myhealthpro.onboarding.service.patient;

import com.sd.myhealthpro.onboarding.dto.request.PatientOnboardingRequest;
import com.sd.myhealthpro.onboarding.service.OnboardingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PatientOnboardingService implements OnboardingService<PatientOnboardingRequest> {


    @Override
    public void processOnboarding(PatientOnboardingRequest onboardingRequest) {
        log.info("Onboarding Patient");
        String pCase = onboardingRequest.getPatientCase();



    }
}
