package com.sd.myhealthpro.onboarding.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class PatientOnboardingRequest extends OnboardingRequest{
    @NotBlank(message = "case is mandatory")
    String patientCase;
}
