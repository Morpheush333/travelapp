package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
