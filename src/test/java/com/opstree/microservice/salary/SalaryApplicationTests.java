package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(
    classes = {SalaryApplication.class, SalaryApplicationTests.TestConfig.class},
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    RedisAutoConfiguration.class,
    CassandraAutoConfiguration.class
})
class SalaryApplicationTests {

    @Configuration
    static class TestConfig {
        @Bean
        RedisConnectionFactory redisConnectionFactory() {
            return org.mockito.Mockito.mock(RedisConnectionFactory.class);
        }

        @Bean
        RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
            return new RedisTemplate<>();
        }
    }

    @Test
    void contextLoads() {
        // Passes if context starts successfully
    }
}
