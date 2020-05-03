package com.ysachot.donsang.service.openstreet;

import com.ysachot.donsang.service.openstreet.bean.OpenStreetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class OpenStreetService {

    @Value("${open.street.api.key}")
    private String apiKey;

    @Value("${open.street.base.url}")
    private String openStreetBaseUrl;

    @Value("${open.street.address.encoding.url}")
    private String openStreetAddressEncodingUrl;

    @Autowired
    private RestTemplate restTemplate;

    public OpenStreetDto getEncoodedAddress(String address) {
        return restTemplate.getForObject(
                openStreetBaseUrl + openStreetAddressEncodingUrl + "address=" + address + "&key=" + apiKey,
                OpenStreetDto.class);
    }
}