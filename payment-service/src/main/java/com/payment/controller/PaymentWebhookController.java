package com.payment.controller;

import com.payment.service.PaymentWebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentWebhookController {
    @Autowired
    PaymentWebhookService paymentWebhookService;
    private static final String RAZORPAY_SECRET = "mySecret123";

    @PostMapping("/webhook")
    public String handleWebhook(@RequestBody String payload,
                                                @RequestHeader(value = "X-Razorpay-Signature", required = false) String signature) throws Exception {
       return paymentWebhookService.fetchingPaymentWebhook(payload,signature);
    }

}

