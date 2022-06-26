package com.sb.gltkn.api;

import com.sb.gltkn.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageAPI {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> createMessage(@RequestBody String message){
        return ResponseEntity.ok(messageService.createMessage(message));
    }
}
