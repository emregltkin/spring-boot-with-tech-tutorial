package com.sb.gltkn.controller;

import com.sb.gltkn.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    //@SendTo("/topic")
    //@SendToUser
    public void chatEndpoint(@Payload MessageDto messageDto){
        System.out.println(messageDto);
        messagingTemplate.convertAndSend("/topic", messageDto);
    }
}
