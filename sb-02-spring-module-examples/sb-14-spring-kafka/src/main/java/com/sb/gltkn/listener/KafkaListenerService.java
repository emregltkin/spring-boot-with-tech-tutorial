package com.sb.gltkn.listener;

import com.sb.gltkn.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${sb.gltkn.kafka.topic}",
            groupId = "${sb.gltkn.kafka.group.id}"
    )
    public void listen(@Payload MessageDto message) {
        log.info("Message received.. MessageID : {} Message: {} Date : {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate());
    }
}
