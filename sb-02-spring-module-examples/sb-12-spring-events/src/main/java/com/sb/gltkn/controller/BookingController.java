package com.sb.gltkn.controller;

import com.sb.gltkn.dto.HotelBook;
import com.sb.gltkn.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void bookHotel(@RequestBody HotelBook hotelBook){
        reservationService.publishReservationEvent(hotelBook);
        System.out.println("Kullanıcı isteği işleme alındı." + hotelBook);
    }
}
