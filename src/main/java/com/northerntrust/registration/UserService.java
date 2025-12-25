package com.northerntrust.registration;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private OtpService otpService;

    public void registerUser(UserRegistrationRequest request) throws Exception {
        // Logic for saving user data to the database
        // Call to OTP service for sending OTP
        otpService.sendOtp(request.getEmail());
    }

    public void verifyOtp(String email, String otp) throws Exception {
        // Logic to verify the OTP and activate user
        otpService.verifyOtp(email, otp);
    }
}