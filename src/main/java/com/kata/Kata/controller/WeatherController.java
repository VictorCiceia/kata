package com.kata.Kata.controller;

import com.kata.Kata.dto.ReportDto;
import com.kata.Kata.dto.WeatherDto;
import com.kata.Kata.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{id}")
    public ReportDto findById(@PathVariable String id) {
        return weatherService.findByIdLocation(id);
    }


    @PostMapping
    public ResponseEntity<WeatherDto> create(@RequestBody WeatherDto weatherDto) {
        return ResponseEntity.ok(weatherService.create(weatherDto));
    }

}
