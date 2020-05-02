package com.ysachot.donsang.service;

import com.ysachot.donsang.dto.CsvBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class DatabaseLoader implements CommandLineRunner {

    private CsvService csvService;
    private LocationCollectionService locationCollectionService;

    @Override
    public void run(String... args) throws IOException {
        populateDB(csvService.getBeansFromCsv());
    }

    public void populateDB(List<CsvBean> csvBeans){
        for(CsvBean csvBean:csvBeans){
            locationCollectionService.save(csvBean);
        }
    }
}
