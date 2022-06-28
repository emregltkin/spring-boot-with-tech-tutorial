package com.sb.gltkn.event.listener;

import com.sb.gltkn.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent event) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("EventListener => " + event.getSource().toString());
    }
}
