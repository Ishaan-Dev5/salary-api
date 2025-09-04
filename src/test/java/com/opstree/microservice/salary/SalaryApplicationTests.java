package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
    classes = SalaryApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,   // Skip DB auto-config
    RedisAutoConfiguration.class,        // Skip Redis auto-config
    CassandraAutoConfiguration.class     // Skip Cassandra auto-config
})
@TestConfiguration
public class CassandraMockConfig {
    @Bean
    public EmployeeRepository employeeRepository() {
        return Mockito.mock(EmployeeRepository.class);
    }
}

@ActiveProfiles("test")
class SalaryApplicationTests {

    @Test
    void contextLoads() {
        // Test passes if Spring context loads
    }
}
