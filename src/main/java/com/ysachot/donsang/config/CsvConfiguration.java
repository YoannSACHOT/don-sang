package com.ysachot.donsang.config;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;

@Configuration
@PropertySource("application.properties")
@Slf4j
public class CsvConfiguration {

    @Value("${csv.file.full.path}")
    private String csvFileFullPath;

    @Value("${csv.file.location.download}")
    private String csvFileDownloadLocation;

    @Bean
    public CSVReader csvReader() throws IOException {
        File file = new File(csvFileFullPath);
        if(file.canRead()){
            BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            if(attr.creationTime().toInstant().isBefore(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())){
                log.info("The CSV file is outdated, it will be updated.");
                downloadFile();
            }else{
                log.info("CSV file is up to date.");
            }
        }else{
            log.info("The CSV file doesn't exist, it will be downloaded.");
            downloadFile();
        }

        return new CSVReaderBuilder(Files.newBufferedReader(file.toPath()))
                .withSkipLines(0)
                .withCSVParser(csvParser())
                .build();
    }

    private void downloadFile() throws IOException {
        log.info("Downloading the CSV file from {}...",csvFileDownloadLocation);
        InputStream in = new URL(csvFileDownloadLocation).openStream();
        Files.copy(in, Paths.get(csvFileFullPath), StandardCopyOption.REPLACE_EXISTING);
        log.info("Downloaded the CSV file to " + csvFileFullPath);
    }

    private CSVParser csvParser(){
        return new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();
    }
}
