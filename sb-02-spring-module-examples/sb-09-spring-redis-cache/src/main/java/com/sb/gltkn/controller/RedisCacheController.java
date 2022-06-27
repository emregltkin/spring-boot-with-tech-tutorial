package com.sb.gltkn.controller;

import com.sb.gltkn.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping
    public String getRedisCacheOperation() throws InterruptedException {
        return redisCacheService.loadCachingOperation();
    }

    @GetMapping("/clearCache")
    public String clearRedisCacheOperation() {
        return redisCacheService.clearCacheOperation();
    }
}
