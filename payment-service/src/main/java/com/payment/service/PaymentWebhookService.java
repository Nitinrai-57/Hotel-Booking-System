package com.payment.service;

public interface PaymentWebhookService {
    public String fetchingPaymentWebhook(String payload,String signature) throws Exception;
}
