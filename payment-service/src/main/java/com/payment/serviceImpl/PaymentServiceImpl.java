package com.payment.serviceImpl;

import com.payment.dtos.OrderDetails;
import com.payment.entity.Payment;
import com.payment.repository.PaymentRespository;
import com.payment.service.PaymentService;
import com.razorpay.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;
import java.util.UUID;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    RazorPayServiceImpl razorPayServiceImpl;
    @Autowired
    PaymentRespository paymentRespository;
    @Override
    public OrderDetails createPayment(Long userId, String bookingId, double amount) throws Exception {
        Order order =razorPayServiceImpl.generateOrder(amount,bookingId);
       System.out.println(order);
       OrderDetails orderDetails=new OrderDetails();
       orderDetails.setId(order.get("id"));
       orderDetails.setAmount(order.get("amount"));
        Object createdAtObj = order.get("created_at");

        LocalDateTime createdAt;

        if (createdAtObj instanceof Number) {
            // Razorpay returned a Unix timestamp
            long epochSeconds = ((Number) createdAtObj).longValue();
            createdAt = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSeconds), ZoneId.systemDefault());

        } else if (createdAtObj instanceof Date) {
            // Razorpay returned a Date object
            createdAt = ((Date) createdAtObj).toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

        } else {
            throw new IllegalArgumentException("Unexpected type for created_at: " + createdAtObj.getClass());
        }

        orderDetails.setCreated_at(createdAt);
       orderDetails.setAttempts(order.get("attempts"));
       orderDetails.setEntity(order.get("entity"));
       orderDetails.setCurrency(order.get("currency"));
       orderDetails.setReceipt(order.get("receipt"));
       orderDetails.setAmount_due(order.get( "amount_due"));
       String status= order.get("status");
       orderDetails.setStatus(OrderDetails.Status.CREATED);
       orderDetails.setAmount_paid(order.get("amount_paid"));
      Payment payment= makePayment(orderDetails,userId);





       return orderDetails;
    }

    public Payment makePayment(OrderDetails orderDetails,long userId)
    {
        Payment payment=new Payment();
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setPaymentMethod(Payment.PaymentMethod.UPI);
        payment.setStatus(Payment.Status.INITIATED);
        payment.setAmount(orderDetails.getAmount()/100);
        payment.setTransactionId(orderDetails.getId());
        payment.setCreatedAt(orderDetails.getCreated_at());
        payment.setBookingId(orderDetails.getReceipt());
        payment.setUserId(userId);
        paymentRespository.save(payment);
        return payment;

    }
}
