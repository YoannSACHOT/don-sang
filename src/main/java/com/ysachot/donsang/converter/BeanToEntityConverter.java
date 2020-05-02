package com.ysachot.donsang.converter;

import com.ysachot.donsang.dto.CsvBean;
import com.ysachot.donsang.model.CollectionEntity;
import com.ysachot.donsang.model.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class BeanToEntityConverter {

    public CollectionEntity getCollectionEntity(CsvBean csvBean){

        return CollectionEntity.builder()
                .collectionMorningStartTime(csvBean.getCollectionMorningStartTime())
                .collectionMorningEndTime(csvBean.getCollectionMorningEndTime())
                .collectionAfternoonStartTime(csvBean.getCollectionAfternoonStartTime())
                .collectionAfternoonEndTime(csvBean.getCollectionAfternoonEndTime())
                .collectionDate(csvBean.getCollectionDate())
                .collectionGroupCode(csvBean.getCollectionGroupCode())
                .collectionId(csvBean.getCollectionId())
                .collectionIsPublic(csvBean.getCollectionIsPublic())
                .collectionLpCode(csvBean.getCollectionLpCode())
                .collectionNature(csvBean.getCollectionNature())
                .collectionRegionCode(csvBean.getCollectionRegionCode())
                .build();

    }

    public LocationEntity getLocationEntity(CsvBean csvBean){

        return LocationEntity.builder()
                .locationId(csvBean.getLocationId())
                .locationLatitude(csvBean.getLocationLatitude())
                .locationAddress1(csvBean.getLocationAddress1())
                .locationAddress2(csvBean.getLocationAddress2())
                .locationCity(csvBean.getLocationCity())
                .locationConvocationLabel(csvBean.getLocationConvocationLabel())
                .locationFullAddress(csvBean.getLocationFullAddress())
                .locationGiveBlood(csvBean.isLocationGiveBlood())
                .locationGivePlasma(csvBean.isLocationGivePlasma())
                .locationGivePlatelet(csvBean.isLocationGivePlatelet())
                .locationGroupCode(csvBean.getLocationGroupCode())
                .locationLongitude(csvBean.getLocationLongitude())
                .locationName(csvBean.getLocationName())
                .locationPhone(csvBean.getLocationPhone())
                .locationPostCode(csvBean.getLocationPostCode())
                .locationRegionCode(csvBean.getLocationRegionCode())
                .locationRegionName(csvBean.getLocationRegionName())
                .locationSamplingLocationCode(csvBean.getLocationSamplingLocationCode())
                .build();

    }
}
