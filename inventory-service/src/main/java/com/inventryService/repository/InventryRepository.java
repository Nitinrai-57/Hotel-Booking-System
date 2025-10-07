package com.inventryService.repository;

import com.inventryService.entity.RoomInventry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InventryRepository extends JpaRepository<RoomInventry,Long> {
    public RoomInventry findByRoomIdAndDate(String roomId, LocalDate date);
}
