package com.mateuszmedon.travelapp.repository;

import com.mateuszmedon.travelapp.entity.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
