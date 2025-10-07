package com.inventryService.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="roomInventry")
public class RoomInventry {
    @Id
    private Long id;
    @Column(name="room_id",nullable = false)
    private String roomId;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private int availableRoom;
    @Column(nullable = false)
    private int version;

}
