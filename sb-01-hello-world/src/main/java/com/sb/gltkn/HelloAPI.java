package com.sb.gltkn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloAPI {

    @GetMapping
    public String hello() {
        return "Merhaba!!!";
    }
}
