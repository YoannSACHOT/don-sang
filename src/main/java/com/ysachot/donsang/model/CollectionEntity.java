package com.ysachot.donsang.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CollectionEntity {

    @Id
    private Long collectionId;
    private LocalDate collectionDate;
    private String collectionGroupCode;
    private String collectionIsPublic;
    private String collectionLpCode;
    private LocalTime collectionMorningEndTime;
    private LocalTime collectionMorningStartTime;
    private LocalTime collectionAfternoonEndTime;
    private LocalTime collectionAfternoonStartTime;
    private String collectionRegionCode;
    private String collectionNature;

}
