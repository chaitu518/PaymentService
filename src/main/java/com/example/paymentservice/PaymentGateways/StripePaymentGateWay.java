package com.example.paymentservice.PaymentGateways;

public class StripePaymentGateWay implements PaymentGateWay{
    @Override
    public String createPaymentLink(Long orderId) {
        return "";
    }
}
