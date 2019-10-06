package com.mateuszmedon.travelapp.controller;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import com.mateuszmedon.travelapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("trips")
public class TripController {

    @Autowired
    private TripService tripService;


    @GetMapping
    public List<Trip> getAll() {
        return Collections.emptyList();
    }

    @PostMapping
    public Trip create(@RequestBody Trip trip){
        return tripService.validateAndSave(trip);
    }
}
