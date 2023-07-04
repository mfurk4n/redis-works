package com.redisworks.redisworks.datatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class RedisSortedSet {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "sortedkey";

    public void runExample() {
        addToSortedSet("furkan", 1000);
        addToSortedSet("linus", 2000);
        addToSortedSet("dennis", 3000);
        System.out.println(getRangeByScore(2000, 3000));
        System.out.println(getRangeByRank(2, 3));
        System.out.println(getCountByScore(2000, 3000));

    }

    public void addToSortedSet(String player, int score) {
        redisTemplate.opsForZSet().add(KEY, player, score);
    }

    public Set<Object> getRangeByScore(int minScore, int maxScore) {
        return redisTemplate.opsForZSet().rangeByScore(KEY, minScore, maxScore);
    }

    public Set<Object> getRangeByRank(int start, int end) {
        return redisTemplate.opsForZSet().range(KEY, start, end);
    }

    public Long getCountByScore(int minScore, int maxScore) {
        return redisTemplate.opsForZSet().count(KEY, minScore, maxScore);
    }


}

