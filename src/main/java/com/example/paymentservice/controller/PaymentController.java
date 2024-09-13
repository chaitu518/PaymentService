package com.example.paymentservice.controller;


import com.example.paymentservice.dtos.CreatePaymentLinkRequestBody;
import com.example.paymentservice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public ResponseEntity<String> createPaymentLink(@RequestBody CreatePaymentLinkRequestBody paymentLinkRequestBody){

        try {
             return new ResponseEntity<>(paymentService.createPaymentLink(paymentLinkRequestBody.getOrderId()), HttpStatus.OK);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            //System.out.println("Error while creating payment link");
            //e.printStackTrace();
        }

    }
}
