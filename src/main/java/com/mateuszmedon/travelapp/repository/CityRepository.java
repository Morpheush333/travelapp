package com.mateuszmedon.travelapp.repository;


import com.mateuszmedon.travelapp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CityRepository extends JpaRepository<City, Long> {
}
