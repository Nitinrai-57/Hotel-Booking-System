package com.bookingservice.serviceImpl;

import com.bookingservice.dtos.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentValidationService {
@Autowired
    RestTemplate restTemplate;
    public OrderDetails generateOrder(Long userId, String bookingId, double amount){
        String url = "http://PAYMENTSERVICE/payment/createpayment?userId={userId}&bookingId={bookingId}&amount={amount}";

        OrderDetails orderDetails = restTemplate.postForObject(
                url,
                null, // no request body
                OrderDetails.class,
                1,                  // userId
                "98fjhiosxudc34",   // bookingId
                500                  // amount
        );
        return orderDetails;
    }

}
