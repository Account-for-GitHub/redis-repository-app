package com.example.reporedisapp.app.loadData;

import com.example.reporedisapp.app.RedisMessageRepository;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    public DataLoader(RedisConnectionFactory redisConnectionFactory, RedisMessageRepository redisMessageRepository) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.redisMessageRepository = redisMessageRepository;
    }

    private final RedisMessageRepository redisMessageRepository;
    private final List<Message> messages = List.of(
            new Message("1", 1.1, "Message 1"),
            new Message("2", 2.2, "Message 2"),
            new Message("3", 3.3, "Message 3")
    );

    private final RedisConnectionFactory redisConnectionFactory;
    private Integer currentMessageNumber = 0;

    public void loadData() {
        Message message = messages.get(currentMessageNumber);

        redisConnectionFactory.getConnection().serverCommands().flushDb();
        redisMessageRepository.save(message);

        increaseCurrentMessageNumber();
    }

    private void increaseCurrentMessageNumber() {
        currentMessageNumber++;
        if (currentMessageNumber >= messages.size()) {
            currentMessageNumber = 0;
        }
    }
}
