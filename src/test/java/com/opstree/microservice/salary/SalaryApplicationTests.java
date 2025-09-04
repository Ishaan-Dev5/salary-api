package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import static org.mockito.Mockito.mock;

@SpringBootTest(
    classes = {SalaryApplicationTests.TestConfig.class},
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    RedisAutoConfiguration.class,
    CassandraAutoConfiguration.class
})
class SalaryApplicationTests {

    @Test
    void contextLoads() {
        // Ensures Spring context starts successfully
    }

    @Configuration
    @Import({SalaryApplication.class})
    static class TestConfig {

        @Bean
        public RedisTemplate<Object, Object> redisTemplate() {
            return mock(RedisTemplate.class);
        }

        @Bean
        public RedisCacheManager cacheManager() {
            return mock(RedisCacheManager.class);
        }
    }
}
