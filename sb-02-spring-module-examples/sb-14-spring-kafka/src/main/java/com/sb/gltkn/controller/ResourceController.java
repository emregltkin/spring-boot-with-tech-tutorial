package com.sb.gltkn.controller;

import com.sb.gltkn.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class ResourceController {

    @Value("${sb.gltkn.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody MessageDto messageDto) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), messageDto);
    }
}
