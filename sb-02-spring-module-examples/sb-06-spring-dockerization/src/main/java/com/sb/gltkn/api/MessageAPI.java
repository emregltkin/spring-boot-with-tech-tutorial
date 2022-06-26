package com.sb.gltkn.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageAPI {

    @GetMapping
    public String sendMessage(){
        return "Docker Image'den gönderildi.";
    }
}
