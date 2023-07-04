package com.redisworks.redisworks.datatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class RedisSet {

    private final RedisTemplate<String, String> redisTemplate;
    private static final String KEY = "setkey";

    public void runExample() {
        addToSet("furkan");
        addToSet("linus");
        System.out.println(getSet());
        System.out.println(isMember("furkan"));
        System.out.println(getSetSize());

    }

    public void addToSet(String value) {
        redisTemplate.opsForSet().add(KEY, value);
    }

    public Set<String> getSet() {
        return redisTemplate.opsForSet().members(KEY);
    }

    public boolean isMember(String value) {
        return redisTemplate.opsForSet().isMember(KEY, value);
    }

    public void removeFromSet(String value) {
        redisTemplate.opsForSet().remove(KEY, value);
    }

    public long getSetSize() {
        return redisTemplate.opsForSet().size(KEY);
    }
}

