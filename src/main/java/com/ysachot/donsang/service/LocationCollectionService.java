package com.ysachot.donsang.service;

import com.ysachot.donsang.converter.BeanToEntityConverter;
import com.ysachot.donsang.dto.CsvBean;
import com.ysachot.donsang.model.repo.CollectionRepository;
import com.ysachot.donsang.model.repo.LocationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LocationCollectionService {

    CollectionRepository collectionRepository;
    LocationRepository locationRepository;
    BeanToEntityConverter beanToEntityConverter;

    public void save(CsvBean csvBean){
        collectionRepository.saveAndFlush(beanToEntityConverter.getCollectionEntity(csvBean));
        locationRepository.saveAndFlush(beanToEntityConverter.getLocationEntity(csvBean));
    }

}
