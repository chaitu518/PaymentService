package com.example.paymentservice.service;

import com.example.paymentservice.PaymentGateways.PaymentGateWay;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    PaymentGateWay paymentGateWay;
    public PaymentService(PaymentGateWay paymentGateWay) {
        this.paymentGateWay = paymentGateWay;
    }
    public String createPaymentLink(Long orderId) throws RazorpayException {
        System.out.println();
        return paymentGateWay.createPaymentLink(orderId);
    }

}
