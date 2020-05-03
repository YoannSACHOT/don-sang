package com.ysachot.donsang.service;

import com.ysachot.donsang.dto.CsvBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@PropertySource("classpath:application.properties")
public class CsvService {

    @Value("${csv.file.full.path}")
    private String csvFileFullPath;

    @Value("${csv.file.location.download}")
    private String csvFileDownloadLocation;

    public List<CsvBean> getBeansFromCsv() throws IOException {
        log.info("Extracting data...");
        File file = new File(csvFileFullPath);
        List<CsvBean> csvBeans = new ArrayList<>();

        if(file.canRead()) {
            try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {

                StringBuilder fullFile = new StringBuilder(StringUtils.EMPTY);
                String myline;
                do {
                    myline = reader.readLine();
                    if (!StringUtils.startsWith(myline,"location_") && myline != null) fullFile.append(myline);
                } while (myline != null);
                csvBeans = splitString(fullFile.toString(), 33);
            }
        }else{
            log.error("File is absent or un readable. Should be at {}",csvFileFullPath);
        }
        log.info("Data extracted.");
        return csvBeans;
    }

    public void updateCSVFile() throws IOException {
        downloadFile();
    }

    private void downloadFile() throws IOException {
        log.info("Downloading the CSV file from {}...", csvFileDownloadLocation);
        InputStream in = new URL(csvFileDownloadLocation).openStream();
        Files.copy(in, Paths.get(csvFileFullPath), StandardCopyOption.REPLACE_EXISTING);
        log.info("Downloaded the CSV file to " + csvFileFullPath);
    }

    private List<CsvBean> splitString(String s,int max){
        List<CsvBean> csvBeans = new ArrayList<>();
        List<String> splitted = new ArrayList<>();
        int start = 0;
        int count = 0;
        boolean isInDoubleQuote = false;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='\"'){
                isInDoubleQuote=!isInDoubleQuote;
            }
            if (!isInDoubleQuote && s.charAt(i)==',') {
                splitted.add(s.substring(start,i));
                count++;
                start = i+1;
            }
            if(count==max-1){
                splitted.add("");
                csvBeans.add(getCsvBeanFromStringList(splitted));
                count=0;
                splitted.clear();
            }
        }
        return csvBeans;
    }

    private CsvBean getCsvBeanFromStringList(List<String> lineSplit){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return CsvBean.builder()
                .locationAddress1(lineSplit.get(0))
                .locationAddress2(lineSplit.get(1))
                .locationCity(lineSplit.get(2))
                .locationConvocationLabel(lineSplit.get(3))
                .locationFullAddress(lineSplit.get(4))
                .locationGiveBlood(Boolean.getBoolean(lineSplit.get(5)))
                .locationGivePlasma(Boolean.getBoolean(lineSplit.get(6)))
                .locationGivePlatelet(Boolean.getBoolean(lineSplit.get(7)))
                .locationGroupCode(lineSplit.get(8))
                .locationId(Long.parseLong(lineSplit.get(9)))
                .locationLatitude(Double.parseDouble(lineSplit.get(10)))
                .locationLongitude(Double.parseDouble(lineSplit.get(11)))
                .locationName(lineSplit.get(12))
                .locationPhone(lineSplit.get(13))
                .locationPostCode(lineSplit.get(14))
                .locationRegionCode(lineSplit.get(15))
                .locationRegionName(lineSplit.get(16))
                .locationSamplingLocationCode(lineSplit.get(17))
                .locationHoraires(lineSplit.get(18))
                .locationInfos(lineSplit.get(19))
                .locationDebutInfos(lineSplit.get(20))
                .locationFinInfos(lineSplit.get(21))
                .collectionDate(LocalDate.parse(lineSplit.get(22)))
                .collectionGroupCode(lineSplit.get(23))
                .collectionId(Long.parseLong(lineSplit.get(24)))
                .collectionIsPublic(lineSplit.get(25))
                .collectionLpCode(lineSplit.get(26))
                .collectionMorningEndTime(StringUtils.isNotEmpty(lineSplit.get(27)) ? LocalTime.parse(lineSplit.get(27), formatter) : null)
                .collectionMorningStartTime(StringUtils.isNotEmpty(lineSplit.get(28)) ? LocalTime.parse(lineSplit.get(28), formatter) : null)
                .collectionAfternoonEndTime(StringUtils.isNotEmpty(lineSplit.get(29)) ? LocalTime.parse(lineSplit.get(29), formatter) : null)
                .collectionAfternoonStartTime(StringUtils.isNotEmpty(lineSplit.get(30)) ? LocalTime.parse(lineSplit.get(30), formatter) : null)
                .collectionRegionCode(lineSplit.get(31))
                .collectionNature(lineSplit.get(32))
                .build();
    }
}
