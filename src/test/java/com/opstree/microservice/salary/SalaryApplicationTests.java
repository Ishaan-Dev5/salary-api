package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(
    classes = SalaryApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    RedisAutoConfiguration.class,
    CassandraAutoConfiguration.class
})
@Import(TestConfig.class)
class SalaryApplicationTests {

    @Test
    void contextLoads() {
        // Test passes if context starts successfully
    }
}
