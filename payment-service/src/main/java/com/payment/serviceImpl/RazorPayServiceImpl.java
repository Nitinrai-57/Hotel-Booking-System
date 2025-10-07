package com.payment.serviceImpl;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazorPayServiceImpl {
    @Autowired
    RazorpayClient razorpayClient;
    public Order generateOrder(double amount,String receiptId) throws Exception {
       int amountInPaisa=(int)(amount*100);
        JSONObject orderRequest=new JSONObject();
        orderRequest.put("amount",amountInPaisa);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt",receiptId);
        return razorpayClient.orders.create(orderRequest);
    }
}
