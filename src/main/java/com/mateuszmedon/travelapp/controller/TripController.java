package com.mateuszmedon.travelapp.controller;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import com.mateuszmedon.travelapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("trips")
public class TripController {

    @Autowired
    private TripService tripService;


    @GetMapping
    public List<Trip> getAll() {
        return tripService.getAllTrips();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trip create(@RequestBody Trip trip){
        return tripService.validateAndSave(trip);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        tripService.deleteTrip(id);
    }

    @GetMapping("{id}")
    public Trip getById(@PathVariable Long id) {
        return tripService.getById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Trip update(@RequestBody Trip trip, @PathVariable Long id) {
        return tripService.update(trip,id);
    }
}
