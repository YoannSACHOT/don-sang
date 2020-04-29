package com.ysachot.donsang.service;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ysachot.donsang.dto.CsvBean;
import com.ysachot.donsang.dto.Location;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CsvService {

    ApplicationContext context;

    public List<CsvBean> test() throws IOException {
        ColumnPositionMappingStrategy ms = new ColumnPositionMappingStrategy();
        CSVReader reader = context.getBean("csvReader", CSVReader.class);
        CsvToBean cb = new CsvToBeanBuilder<CsvBean>(reader)
                .withMappingStrategy(ms)
                .build();
        List<CsvBean> csvBeans = cb.parse();
        reader.close();

        return csvBeans;
    }

}
