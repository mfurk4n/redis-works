package com.redisworks.redisworks.datatypes;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RedisGeospatial {

    private final RedisTemplate<String, String> redisTemplate;

    public void runExample() {
        final String key = "school";
        final double longitude = 38.0;
        final double latitude = 17.0;

        addLocation(key, longitude, latitude);
        printInRadius(key, longitude, latitude, 1);
    }

    public void addLocation(String key, double longitude, double latitude) {
        Map<String, Point> schools = Map.of("school", new Point(longitude, latitude));
        redisTemplate.opsForGeo().add(key, schools);
    }

    public void printInRadius(String key, double longitude, double latitude, double radius) {
        Circle circle = new Circle(longitude, latitude, radius);
        Objects.requireNonNull(redisTemplate.opsForGeo().radius(key, circle)).forEach(System.out::println);
    }

}
