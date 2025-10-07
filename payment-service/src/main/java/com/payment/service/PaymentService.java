package com.payment.service;

import com.payment.dtos.OrderDetails;
import com.payment.entity.Payment;

public interface PaymentService {
    public OrderDetails createPayment(Long userId, String bookingId, double amount) throws Exception;
}
