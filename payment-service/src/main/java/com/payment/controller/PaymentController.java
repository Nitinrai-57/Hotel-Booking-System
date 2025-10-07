package com.payment.controller;

import com.payment.dtos.OrderDetails;
import com.payment.entity.Payment;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("/createpayment")
    public OrderDetails createPayment(@RequestParam Long userId, @RequestParam String bookingId, @RequestParam double amount) throws Exception {
       return paymentService.createPayment(userId,bookingId,amount);
    }
}
