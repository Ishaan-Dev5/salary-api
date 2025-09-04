package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class SalaryApplicationTests {

    @MockBean
    private DataSource dataSource;   // Mock DB connection

    @MockBean
    private RedisTemplate<String, Object> redisTemplate;  // Mock Redis connection

    // Remove CassandraTemplate if you don't have dependency
    // @MockBean
    // private CassandraTemplate cassandraTemplate;

    @Test
    void contextLoads() {}
}
