package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(
    classes = SalaryApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    RedisAutoConfiguration.class,
    CassandraAutoConfiguration.class
})
@ActiveProfiles("test")
@TestPropertySource(properties = {
    "spring.data.cassandra.repositories.enabled=false"
})
class SalaryApplicationTests {

    @Test
    void contextLoads() {
        // Passes if Spring context loads without Cassandra
    }
}
