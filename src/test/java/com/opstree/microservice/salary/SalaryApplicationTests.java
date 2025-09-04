package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootTest(
    classes = {SalaryApplicationTests.TestConfig.class},
    webEnvironment = SpringBootTest.WebEnvironment.NONE // No web server needed
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class, 
    RedisAutoConfiguration.class, 
    CassandraAutoConfiguration.class
})
class SalaryApplicationTests {

    @Test
    void contextLoads() {
        // This test just ensures the Spring context can start
    }

    /**
     * Test configuration to safely load the context in Jenkins
     */
    @Configuration
    @Import({SalaryApplication.class}) // Import your main application class
    static class TestConfig {
        // You can define mock beans here if any required beans fail during context loading
    }
}
