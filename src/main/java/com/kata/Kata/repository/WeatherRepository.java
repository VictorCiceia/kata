package com.kata.Kata.repository;

import com.kata.Kata.entity.LocationEntity;
import com.kata.Kata.entity.WeatherEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends MongoRepository<WeatherEntity, String> {

    Optional<WeatherEntity> findFirstByLocation(LocationEntity location);

}
