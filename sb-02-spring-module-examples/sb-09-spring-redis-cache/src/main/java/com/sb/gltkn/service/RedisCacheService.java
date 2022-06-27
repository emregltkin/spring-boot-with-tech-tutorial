package com.sb.gltkn.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "mySpecialCache")
    public String loadCachingOperation() throws InterruptedException {
        Thread.sleep(5000L);
        return "loadCachingOperation metodu tamamlandı.";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public String clearCacheOperation(){
        return "Cache temizlendi.";
    }
}
