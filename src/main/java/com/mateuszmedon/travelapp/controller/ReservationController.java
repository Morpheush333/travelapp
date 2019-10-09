package com.mateuszmedon.travelapp.controller;

import com.mateuszmedon.travelapp.entity.reservation.Reservation;
import com.mateuszmedon.travelapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.getAllReservations();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.validateAndSave(reservation);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        reservationService.delete(id);
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable Long id) {
        return reservationService.getById(id);
    }


}
