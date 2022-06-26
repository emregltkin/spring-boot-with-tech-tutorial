package com.sb.gltkn.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String createMessage(String message) {
        System.out.println("\ncreateMessage metodu çalıştı!!!");
        System.out.println(message);
        return message;
    }
}
