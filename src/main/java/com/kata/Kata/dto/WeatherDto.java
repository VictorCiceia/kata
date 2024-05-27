package com.kata.Kata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {

    private String id;

    private Double temp;

    private Double pressure;

    private Integer humidity;

    private String idLocation;

}
