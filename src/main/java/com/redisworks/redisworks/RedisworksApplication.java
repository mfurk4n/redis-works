package com.redisworks.redisworks;

import com.redisworks.redisworks.datatypes.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RedisworksApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext context = SpringApplication.run(RedisworksApplication.class, args);

        final RedisString redisString = context.getBean(RedisString.class);
        redisString.runExample();

        final RedisSet redisSet = context.getBean(RedisSet.class);
        redisSet.runExample();

        final RedisSortedSet redisSortedSetExample = context.getBean(RedisSortedSet.class);
        redisSortedSetExample.runExample();

        final RedisList redisList = context.getBean(RedisList.class);
        redisList.runExample();

        final RedisHash redisHash = context.getBean(RedisHash.class);
        redisHash.runExample();

        final RedisGeospatial redisGeospatial = context.getBean(RedisGeospatial.class);
        redisGeospatial.runExample();
    }

}
