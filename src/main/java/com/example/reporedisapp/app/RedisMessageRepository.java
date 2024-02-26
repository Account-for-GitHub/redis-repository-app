package com.example.reporedisapp.app;

import com.example.reporedisapp.app.loadData.Message;
import org.springframework.data.repository.CrudRepository;

public interface RedisMessageRepository extends CrudRepository<Message, String> {
}
