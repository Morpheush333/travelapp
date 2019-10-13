package com.mateuszmedon.travelapp.repository;


import com.mateuszmedon.travelapp.entity.City;
import com.mateuszmedon.travelapp.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities", excerptProjection = CityProjection.class)
public interface CityRepository extends JpaRepository<City, Long> {
}

@Projection(name = "cityProjection", types = {City.class})
interface CityProjection {
    String getId();

    String getName();

    Country getCountry();
}