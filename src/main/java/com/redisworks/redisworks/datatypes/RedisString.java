package com.redisworks.redisworks.datatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisString {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "stringkey";
    private static final String VALUE = "furkan";

    private static final String KEY2 = "stringkey2";
    private static final String JSON_VALUE = "{\"username\":\"furkan\"}";

    public void runExample() {
        set();
        setJson();
        System.out.println(get());
        System.out.println(getJson());
    }

    public void set() {
        redisTemplate.opsForValue().set(KEY, VALUE);
    }


    public void setJson() {
        redisTemplate.opsForValue().set(KEY2, JSON_VALUE);
    }

    public Object get() {
        return redisTemplate.opsForValue().get(KEY);
    }

    public Object getJson() {
        return redisTemplate.opsForValue().get(KEY2);
    }
}
