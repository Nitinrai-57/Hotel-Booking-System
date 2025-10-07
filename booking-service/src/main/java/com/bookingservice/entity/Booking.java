package com.bookingservice.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="booking")
public class Booking {
    @Id
    private String id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String hotelId;
    @Column(nullable = false)
    private String roomId;
    @Column(name="check_In",nullable = false)
    private LocalDate checkIn;
    @Column(name="check_Out",nullable = false)
    private LocalDate checkOut;
    @Column(nullable = false)
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double totalAmount;
    public enum Status{
        PENDING,CREATED,CONFIRMED,CANCLED
    }

}

