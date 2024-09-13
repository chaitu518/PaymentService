package com.example.paymentservice.Configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfigs {
    @Value("${razor.key.id}")
    private String razorpay_key_id;
    @Value("${razor.secret.id}")
    private String razorpay_key_secret;
    @Bean
    public RazorpayClient createRazorPayClient() throws RazorpayException {
        return new RazorpayClient(razorpay_key_id, razorpay_key_secret);
    }
}
