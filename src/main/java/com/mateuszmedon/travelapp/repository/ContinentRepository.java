package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.Continent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "continents", path = "continents")
public interface ContinentRepository extends JpaRepository<Continent, Long> {

//    Is overriding method and change it.
//    @Override
//    @RestResource(exported = false)
//    Continent save(Continent continent);

//    @RestResource
//    List<Continent> findByNameContaining(@Param("name") String name);



    Page<Continent> findByNameContaining(@Param("name") String name, Pageable pageable);
}
