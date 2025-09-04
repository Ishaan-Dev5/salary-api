
package com.opstree.microservice.salary;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        return mock(RedisTemplate.class);
    }

    @Bean
    public RedisCacheManager cacheManager() {
        return mock(RedisCacheManager.class);
    }
}

