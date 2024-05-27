package com.kata.Kata.service.impl;

import com.kata.Kata.dto.LocationDto;
import com.kata.Kata.entity.LocationEntity;
import com.kata.Kata.repository.LocationRepository;
import com.kata.Kata.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDto create(final LocationDto locationDto) {
        LocationEntity entity = new LocationEntity();
        entity.setCity(locationDto.getCity());
        entity.setCountry(locationDto.getCountry());
        entity.setRegion(locationDto.getRegion());
        entity = this.locationRepository.save(entity);
        locationDto.setId(entity.getId());
        return locationDto;
    }
}
