package com.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="payments")
public class Payment {
    @Id
    private String paymentId;
    private String bookingId;
    private Long userId;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String transactionId;
    private LocalDateTime createdAt;

   public enum Status{
        INITIATED, SUCCESS, FAILED, REFUNDED
    }
   public enum PaymentMethod{
        CARD, UPI, PAYPAL
    }

}


