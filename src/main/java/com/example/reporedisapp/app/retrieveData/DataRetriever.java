package com.example.reporedisapp.app.retrieveData;

import com.example.reporedisapp.app.RedisMessageRepository;
import org.springframework.stereotype.Component;

@Component
public class DataRetriever {
    private final RedisMessageRepository redisMessageRepository;

    public DataRetriever(RedisMessageRepository redisMessageRepository) {
        this.redisMessageRepository = redisMessageRepository;
    }

    public void retrieveAndShowData() {
        redisMessageRepository.findAll().forEach(System.out::println);
    }
}
