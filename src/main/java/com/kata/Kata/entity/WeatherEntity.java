package com.kata.Kata.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "weather")
public class WeatherEntity {

    @Id
    private String id;

    private Double temp;

    private Double pressure;

    private Integer humidity;

    @DBRef
    private LocationEntity location;

}
