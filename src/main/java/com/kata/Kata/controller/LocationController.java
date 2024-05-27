package com.kata.Kata.controller;

import com.kata.Kata.dto.LocationDto;
import com.kata.Kata.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationDto> create(@RequestBody LocationDto locationDto) {
        return ResponseEntity.ok(locationService.create(locationDto));
    }

}
