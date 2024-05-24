package com.sd.myhealthpro.onboarding.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ProfessionalOnboardingRequest extends OnboardingRequest{
    @NotBlank(message = "speciality is mandatory")
    String speciality;

}
