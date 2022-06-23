package com.sb.gltkn.listener;

import com.sb.gltkn.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "gltkn-rabbit-queue")
    public void handleMessage(Notification notification){
        System.out.println("Message Received..");
        System.out.println(notification.toString());
    }
}
