package com.ysachot.donsang.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
@Slf4j
@EnableScheduling
public class DatabaseLoader implements CommandLineRunner {

    private final CsvService csvService;
    private final LocationCollectionService locationCollectionService;

    @Override
    public void run(String... args) throws IOException {
        updateDb();
    }

    @Scheduled(cron="0 0/30 * * * *")
    public void updateDb() throws IOException{
        csvService.updateCSVFile();
        locationCollectionService.populateDB(csvService.getBeansFromCsv());
    }
}
