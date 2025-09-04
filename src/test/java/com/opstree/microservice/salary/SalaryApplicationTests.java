package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;                     // For DataSource
import org.springframework.boot.test.mock.mockito.MockBean;  // For @MockBean
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
// For RedisTemplate


@SpringBootTest
@ActiveProfiles("test")
class SalaryApplicationTests {
	 @MockBean
    private DataSource dataSource;   // Mock DB connection

    @MockBean
    private RedisTemplate redisTemplate;  // Mock Redis conne

	@Test
	void contextLoads() {
	}

}
