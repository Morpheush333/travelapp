package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "continents", path = "continents")
public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
