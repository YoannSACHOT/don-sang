package com.ysachot.donsang.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location extends CsvBean{

    @CsvBindByName(column="location_address1")
    private String address1;
    @CsvBindByName(column="location_address2")
    private String address2;
    @CsvBindByName(column="location_city")
    private String city;
    @CsvBindByName(column="location_convocationLabel")
    private String convocationLabel;
    @CsvBindByName(column="location_fullAddress")
    private String fullAddress;
    @CsvBindByName(column="location_giveBlood")
    private boolean giveBlood;
    @CsvBindByName(column="location_givePlasma")
    private boolean givePlasma;
    @CsvBindByName(column="location_givePlatelet")
    private boolean givePlatelet;
    @CsvBindByName(column="location_groupCode")
    private String groupCode;

}
