package com.sd.myhealthpro.onboarding.service;

import com.sd.myhealthpro.onboarding.dto.request.OnboardingRequest;

public interface OnboardingService<T extends OnboardingRequest> {

     void processOnboarding(T onboardingRequest);

}
