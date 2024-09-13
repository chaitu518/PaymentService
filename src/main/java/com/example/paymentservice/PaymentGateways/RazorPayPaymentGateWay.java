package com.example.paymentservice.PaymentGateways;

import com.razorpay.PaymentLink;
import org.springframework.context.annotation.Primary;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RazorPayPaymentGateWay implements PaymentGateWay{
    private RazorpayClient client;
    public RazorPayPaymentGateWay(RazorpayClient client) {
        this.client = client;
    }
    @Override
    public String createPaymentLink(Long orderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", 1000);
        paymentLinkRequest.put("currency", "INR");
        // paymentLinkRequest.put("accept_partial", true);
        // paymentLinkRequest.put("first_min_partial_amount", 100);
        paymentLinkRequest.put("expire_by", 1726389489);
        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description", "Payment for policy no #23456");

        JSONObject customer = new JSONObject();
        customer.put("name", "Surya Rama Teja");
        customer.put("contact", "+919948991954");
        customer.put("email", "saichaitanya518@gmail.com"); // Corrected email format
        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);
        paymentLinkRequest.put("reminder_enable", true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name", "SURYA");
        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://www.scaler.com/academy/mentee-dashboard/todos");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = client.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
