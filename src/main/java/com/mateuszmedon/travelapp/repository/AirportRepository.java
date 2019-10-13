package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
