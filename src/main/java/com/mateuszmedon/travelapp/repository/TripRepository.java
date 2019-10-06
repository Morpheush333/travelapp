package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TripRepository extends JpaRepository<Trip, Long> {

}
