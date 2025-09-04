package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import static org.mockito.Mockito.mock;

@SpringBootTest(
    classes = SalaryApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    RedisAutoConfiguration.class,
    CassandraAutoConfiguration.class
})
@Import(SalaryApplicationTests.TestRedisConfig.class)
class SalaryApplicationTests {

    @TestConfiguration
    static class TestRedisConfig {
        @Bean
        RedisTemplate<Object, Object> redisTemplate() {
            return mock(RedisTemplate.class);
        }

        @Bean
        RedisCacheManager cacheManager() {
            return mock(RedisCacheManager.class);
        }
    }

    @Test
    void contextLoads() {
        // Passes if context starts successfully
    }
}
