package com.ysachot.donsang.service.openstreet.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OpenStreetDto {

    private List<Result> results;
    private String status;

}
