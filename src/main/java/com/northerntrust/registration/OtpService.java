package com.northerntrust.registration;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

    public void sendOtp(String email) throws Exception {
        // Logic to send OTP via SendGrid or Twilio
    }

    public void verifyOtp(String email, String otp) throws Exception {
        // Logic to verify OTP
    }
}