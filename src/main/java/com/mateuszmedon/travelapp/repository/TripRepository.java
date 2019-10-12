package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByDateStart(LocalDate localDate);
    List<Trip> findByDateFinnishAndDateFinnish(LocalDate departureDate, LocalDate returnDate);
    List<Trip> findByDateStartIsBefore(LocalDate departureDate);

//    @Query("WHERE dateStart < : date")
//    List<Trip> search (LocalDate date);

}
