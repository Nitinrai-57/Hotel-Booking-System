package com.payment.serviceImpl;

import com.payment.entity.Payment;
import com.payment.repository.PaymentRespository;
import com.payment.service.PaymentService;
import com.payment.service.PaymentWebhookService;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
@Service
public class PaymentWebhookServiceImpl implements PaymentWebhookService {
    @Autowired
    PaymentRespository paymentRespository;
    private static final String RAZORPAY_SECRET = "mySecret123";
    @Override
    public String fetchingPaymentWebhook(String payload, String signature) throws Exception {
        boolean isValid=verifySignature(payload,signature,RAZORPAY_SECRET);
        if(!isValid)
        {
            throw new RuntimeException("not valid");
        }
        JSONObject jsonObject=new JSONObject(payload);
        String event=jsonObject.getString("event");
        JSONObject data=jsonObject.getJSONObject("payload");

        if("payment.captured".equals(event)){
            String paymentId=data.getJSONObject("payment").getJSONObject("entity").getString("id");
            String status=data.getJSONObject("payment").getJSONObject("entity").getString("status");
            Long createdAt =data.getJSONObject("payment").getJSONObject("entity").getLong("created_at");
            updatePaymentService(paymentId,status,createdAt);

        }

     return "Webhook received";
    }
    private boolean verifySignature(String payload, String actualSignature, String secret) throws Exception {
        String generatedSignature = hmacSha256(payload, secret);
        return generatedSignature.equals(actualSignature);
    }
    private String hmacSha256(String data, String secret) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    public void updatePaymentService(String paymentId, String status, Long createdAt) {
        Payment payment=new Payment();
        payment.setPaymentId(paymentId);
        payment.setCreatedAt(LocalDateTime.now());
        if(status.equals("captured"))
        {
            payment.setStatus(Payment.Status.SUCCESS);
        }
        else{
            payment.setStatus(Payment.Status.FAILED);
        }
        paymentRespository.save(payment);
    }



}
