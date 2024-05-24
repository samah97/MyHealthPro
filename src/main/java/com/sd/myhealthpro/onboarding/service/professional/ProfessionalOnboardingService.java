package com.sd.myhealthpro.onboarding.service.professional;

import com.sd.myhealthpro.onboarding.dto.request.PatientOnboardingRequest;
import com.sd.myhealthpro.onboarding.dto.request.ProfessionalOnboardingRequest;
import com.sd.myhealthpro.onboarding.service.OnboardingService;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalOnboardingService implements OnboardingService<ProfessionalOnboardingRequest> {
    @Override
    public void processOnboarding(ProfessionalOnboardingRequest onboardingRequest) {
        String speciality = onboardingRequest.getSpeciality();
        System.out.println("Speciality is = "+speciality);
    }
}
