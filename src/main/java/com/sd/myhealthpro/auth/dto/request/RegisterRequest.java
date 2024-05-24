package com.sd.myhealthpro.auth.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "First Name cannot be empty")
        String firstName,
        @NotBlank(message = "Last Name cannot be empty")
        String lastName,
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        String email,
        @NotBlank(message = "Phone number cannot be empty")
        String phone,
        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8, max = 20 , message = "Password must be between 8 and 20 characters")
        String password
) {
}
