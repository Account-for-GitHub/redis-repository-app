package com.example.reporedisapp.app;

import com.example.reporedisapp.app.loadData.DataLoader;
import com.example.reporedisapp.app.retrieveData.DataRetriever;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Controller {
    final DataLoader dataLoader;
    final DataRetriever dataRetriever;

    public Controller(DataLoader dataLoader, DataRetriever dataRetriever) {
        this.dataLoader = dataLoader;
        this.dataRetriever = dataRetriever;
    }

    @Scheduled(fixedDelay = 1000)
    void performRedisActions() {
        System.out.println("Update");
        dataLoader.loadData();
        dataRetriever.retrieveAndShowData();
    }
}
