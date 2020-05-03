package com.ysachot.donsang.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class LocationEntity {

    @Id
    private Long locationId;
    private String locationAddress1;
    private String locationAddress2;
    private String locationCity;
    private String locationConvocationLabel;
    private String locationFullAddress;
    private boolean locationGiveBlood;
    private boolean locationGivePlasma;
    private boolean locationGivePlatelet;
    private String locationGroupCode;
    private double locationLatitude;
    private double locationLongitude;
    private String locationName;
    private String locationPhone;
    private String locationPostCode;
    private String locationRegionCode;
    private String locationRegionName;
    private String locationSamplingLocationCode;
    private String locationHoraires;
    private String locationInfos;
    private String locationDebutInfos;
    private String locationFinInfos;

}
