package com.opstree.microservice.salary;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalaryApplicationTests {
	 @MockBean
    private DataSource dataSource;   // Mock DB connection

    @MockBean
    private RedisTemplate redisTemplate;  // Mock Redis conne

	@Test
	void contextLoads() {
	}

}
