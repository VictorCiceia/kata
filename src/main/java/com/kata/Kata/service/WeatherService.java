package com.kata.Kata.service;

import com.kata.Kata.dto.ReportDto;
import com.kata.Kata.dto.WeatherDto;

public interface WeatherService {

    ReportDto findByIdLocation(final String id);

    WeatherDto create(WeatherDto weatherDto);
}
