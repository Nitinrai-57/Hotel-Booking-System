package com.bookingservice.serviceImpl;

import com.bookingservice.dtos.*;
import com.bookingservice.entity.Booking;
import com.bookingservice.repository.BookingRepository;
import com.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    UserValidationService userValidationService;
    @Autowired
    HotelValidationService hotelValidationService;
    @Autowired
    RoomValidationService roomValidationService;
    @Autowired
    IntentryValidationService intentryValidationService;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PaymentValidationService paymentValidationService;
    @Override
    public Booking createBooking(BookingDetails booking) {
       UserDetails user=userValidationService.findUserDetails(booking.getUserId());
        if(user==null){
            throw new RuntimeException("user is not found");
        }
        HotelDetails hotelDetails=hotelValidationService.findHotel(booking.getHotelId());
        if(hotelDetails==null)
        {
            throw new RuntimeException("hotel is not found");
        }
        List<RoomDetails>allHotelrooms =roomValidationService.findRoom(hotelDetails.getHotelId());
        RoomDetails validatedRoom=validatedRoom(allHotelrooms, booking.getRoomId());
        if(validatedRoom==null)
        {
            throw new RuntimeException("Room is not found");
        }
        InventryDetails inventryDetails =intentryValidationService.getInventryDataForTheDate(booking.getRoomId(),booking.getCheckIn());

       if(booking.getQuantity()>inventryDetails.getAvailableRoom()){
           throw new RuntimeException("rooms are not available please check availability");
       }
       String bookingId=UUID.randomUUID().toString();

       Booking bookingData=new Booking();
       bookingData.setId(bookingId);
       bookingData.setUserId(booking.getUserId());
       bookingData.setRoomId(booking.getRoomId());
       bookingData.setHotelId(booking.getHotelId());
       bookingData.setQuantity(booking.getQuantity());
       bookingData.setCheckIn(booking.getCheckIn());
       bookingData.setCheckOut(booking.getCheckOut());
       bookingData.setTotalAmount(booking.getQuantity()*validatedRoom.getPricePerNight());
       bookingData.setStatus(Booking.Status.PENDING);
       Booking bookingresult=bookingRepository.save(bookingData);
       OrderDetails orderDetails=paymentValidationService.generateOrder(booking.getUserId(),bookingId,booking.getQuantity()*validatedRoom.getPricePerNight());



       return bookingresult;

    }
    public RoomDetails validatedRoom(List<RoomDetails> allHotelrooms,String bookingId)
    {
        for(RoomDetails roomDetails:allHotelrooms)
        {
            if(roomDetails.getRoomId().equals(bookingId))
            {
                return roomDetails;
            }
        }
        return null;
    }
}
