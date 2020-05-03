package com.ysachot.donsang.service.openstreet.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {

    public double lat;
    public double lng;

}
