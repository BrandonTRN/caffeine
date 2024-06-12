package com.brtn.traine.caffeine.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;


import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
public class CacheConfig {

    @Value("${cache.users.info.ttl:24}")
    private long cacheUsersInfoTtl;

    @Value("${cache.users.info.max-size:3}")
    private long cacheUsersInfoMaxSize;

    public static final String USERS_INFO_CACHE = "USERS_INFO_CACHE";

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Collections.singleton(this.buildCache(USERS_INFO_CACHE,
                cacheUsersInfoTtl, TimeUnit.HOURS, cacheUsersInfoMaxSize)));
        return manager;
    }

    private static CaffeineCache buildCache(String name, long ttl, TimeUnit ttlUnit, long size) {
        return new CaffeineCache(name, Caffeine.newBuilder().expireAfterWrite(ttl, ttlUnit).maximumSize(size).build());
    }

}
