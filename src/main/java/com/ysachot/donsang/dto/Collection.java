package com.ysachot.donsang.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collection {

    @CsvBindByName(column="date")
    private LocalDate date;
    @CsvBindByName(column="groupCode")
    private String groupCode;
    @CsvBindByName(column="id")
    private Long id;
    @CsvBindByName(column="isPublic")
    private String isPublic;
    @CsvBindByName(column="lpCode")
    private String lpCode;
    @CsvBindByName(column="morningEndTime")
    private LocalDateTime morningEndTime;
    @CsvBindByName(column="morningStartTime")
    private LocalDateTime morningStartTime;
    @CsvBindByName(column="afternoonEndTime")
    private LocalDateTime afternoonEndTime;
    @CsvBindByName(column="afternoonStartTime")
    private LocalDateTime afternoonStartTime;
    @CsvBindByName(column="regionCode")
    private String regionCode;
    @CsvBindByName(column="nature")
    private String nature;

}
