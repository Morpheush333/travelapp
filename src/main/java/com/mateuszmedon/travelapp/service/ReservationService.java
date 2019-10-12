package com.mateuszmedon.travelapp.service;

import com.mateuszmedon.travelapp.entity.reservation.Reservation;
import com.mateuszmedon.travelapp.exception.NotFoundExceptionId;
import com.mateuszmedon.travelapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation validateAndSave(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void delete(Long id) {
        if(!reservationRepository.existsById(id)){
            throw new NotFoundExceptionId(
                    "Invalid id to delete: ");

        }
        reservationRepository.existsById(id);
    }

    public Reservation getById(Long id) {

        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if(!optionalReservation.isPresent()){
            throw new NotFoundExceptionId(
                    "Invalid id to find: ");
        }
        return optionalReservation.get();
    }

    public Reservation update(Reservation reservation, Long id) {

        if (!reservationRepository.existsById(id)){

        }
        reservation.setId(id);
        return reservationRepository.save(reservation);

    }
}
