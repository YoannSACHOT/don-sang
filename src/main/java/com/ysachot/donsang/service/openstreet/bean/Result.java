package com.ysachot.donsang.service.openstreet.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {

    private String formatted_address;
    private Geometry geometry;

}
