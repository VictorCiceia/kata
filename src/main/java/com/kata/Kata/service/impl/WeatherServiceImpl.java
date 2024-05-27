package com.kata.Kata.service.impl;

import com.kata.Kata.dto.LocationDto;
import com.kata.Kata.dto.ReportDto;
import com.kata.Kata.dto.WeatherDto;
import com.kata.Kata.entity.LocationEntity;
import com.kata.Kata.entity.WeatherEntity;
import com.kata.Kata.repository.LocationRepository;
import com.kata.Kata.repository.WeatherRepository;
import com.kata.Kata.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public ReportDto findByIdLocation(final String id) {
        final LocationEntity location = this.locationRepository.findById(id).get();
        final WeatherEntity entity = this.weatherRepository.findFirstByLocation(location).get();
        return this.toDto(entity);
    }

    @Override
    public WeatherDto create(final WeatherDto weatherDto) {
        final LocationEntity location = this.locationRepository.findById(weatherDto.getIdLocation()).get();
        WeatherEntity entity = new WeatherEntity();
        entity.setTemp(weatherDto.getTemp());
        entity.setHumidity(weatherDto.getHumidity());
        entity.setPressure(weatherDto.getPressure());
        entity.setLocation(location);
        entity = this.weatherRepository.save(entity);
        weatherDto.setId(entity.getId());
        return weatherDto;
    }

    private ReportDto toDto(final WeatherEntity entity) {
        final ReportDto dto = new ReportDto();
        // Weather
        final WeatherDto weatherDto = new WeatherDto();
        weatherDto.setHumidity(entity.getHumidity());
        weatherDto.setPressure(entity.getPressure());
        weatherDto.setTemp(entity.getTemp());
        weatherDto.setId(entity.getId());
        weatherDto.setIdLocation(entity.getLocation().getId());
        dto.setWeather(weatherDto);
        // Location
        final LocationDto locationDto = new LocationDto();
        locationDto.setCity(entity.getLocation().getCity());
        locationDto.setRegion(entity.getLocation().getRegion());
        locationDto.setCountry(entity.getLocation().getCountry());
        locationDto.setId(entity.getLocation().getId());
        dto.setLocation(locationDto);
        return dto;
    }


}
