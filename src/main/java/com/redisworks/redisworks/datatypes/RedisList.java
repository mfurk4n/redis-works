package com.redisworks.redisworks.datatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RedisList {

    private final RedisTemplate<String, String> redisTemplate;
    private static final String KEY = "listkey";

    public void runExample() {
        pushListFifo("linus");
        pushListLifo("furkan");
        System.out.println(getList());
        System.out.println(getListSize());

    }

    public void pushListFifo(String value) {
        redisTemplate.opsForList().leftPush(KEY, value);
    }

    public void popListFifo() {
        redisTemplate.opsForList().leftPop(KEY);
    }

    public void pushListLifo(String value) {
        redisTemplate.opsForList().rightPush(KEY, value);
    }

    public void popListLifo() {
        redisTemplate.opsForList().rightPop(KEY);
    }

    public List<String> getList() {
        return redisTemplate.opsForList().range(KEY, 0, -1);
    }

    public long getListSize() {
        return redisTemplate.opsForList().size(KEY);
    }
}
