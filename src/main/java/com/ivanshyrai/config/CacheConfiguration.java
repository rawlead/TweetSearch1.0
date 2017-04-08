package com.ivanshyrai.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration {


//    caches expire after 10 minutes
//    @Bean
//    public CacheManager cacheManager() {
//        GuavaCacheManager cacheManager = new GuavaCacheManager("searches");
//        cacheManager.setCacheBuilder(CacheBuilder.newBuilder()
//        .softValues()
//        .expireAfterWrite(10, TimeUnit.MINUTES));
//        return cacheManager;
//    }

    @Bean
    public CacheManager cacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("searches")
        ));
        return simpleCacheManager;
    }

}
