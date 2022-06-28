package com.sb.gltkn.service;

import com.sb.gltkn.dto.HotelBook;
import com.sb.gltkn.event.ReservationCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Async
    public void publishReservationEvent(HotelBook hotelBook){
        publisher.publishEvent(new ReservationCreatedEvent(hotelBook));
    }
}
