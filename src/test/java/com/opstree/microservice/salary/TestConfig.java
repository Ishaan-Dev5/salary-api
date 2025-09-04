@TestConfiguration
class TestRedisConfig {
    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        return mock(RedisTemplate.class);
    }

    @Bean
    RedisCacheManager cacheManager() {
        return mock(RedisCacheManager.class);
    }
}
