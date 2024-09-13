package com.example.paymentservice.PaymentGateways;

import com.razorpay.RazorpayException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


public interface PaymentGateWay {
    public String createPaymentLink(Long orderId) throws RazorpayException;
}
