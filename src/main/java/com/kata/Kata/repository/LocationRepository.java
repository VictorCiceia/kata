package com.kata.Kata.repository;

import com.kata.Kata.entity.LocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<LocationEntity, String> {
}
