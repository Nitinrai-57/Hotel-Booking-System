package com.payment.dtos;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OrderDetails {
       private int amount;
        private int amount_paid;
        private LocalDateTime created_at;
        private int amount_due;
        private String currency;
        private String receipt;
        private String id;
        private String entity;
        private int attempts;
        @Enumerated(EnumType.STRING)
        private Status status;

        public enum Status{
            CREATED,FAILED
        }
    }
