package com.redisworks.redisworks.datatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RedisHash {
    private final RedisTemplate<String, Object> redisTemplate;
    private static final String HASH_KEY = "hashkey";

    public void runExample() {
        put("furkan", 1000);
        put("linus", 2000);
        System.out.println(containsKey("furkan"));
        System.out.println(getAll());
    }

    public void put(String key, Object value) {
        redisTemplate.opsForHash().put(HASH_KEY, key, value);

    }

    public Object get(String key) {
        return redisTemplate.opsForHash().get(HASH_KEY, key);
    }

    public Object getAll() {
        return redisTemplate.opsForHash().entries(HASH_KEY);
    }

    public boolean containsKey(String key) {
        return redisTemplate.opsForHash().hasKey(HASH_KEY, key);
    }

    public void delete(String key) {
        redisTemplate.opsForHash().delete(HASH_KEY, key);
    }
}
