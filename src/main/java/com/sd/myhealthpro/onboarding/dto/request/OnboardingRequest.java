package com.sd.myhealthpro.onboarding.dto.request;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sd.myhealthpro.onboarding.enums.USER_TYPE;
import lombok.Getter;
import lombok.Setter;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "userType",
//        include= JsonTypeInfo.As.EXISTING_PROPERTY,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PatientOnboardingRequest.class,name = "PATIENT"),
        @JsonSubTypes.Type(value = ProfessionalOnboardingRequest.class,name = "PROFESSIONAL")
})
@Getter
@Setter
public abstract sealed class OnboardingRequest permits PatientOnboardingRequest, ProfessionalOnboardingRequest {
    USER_TYPE userType;
}
