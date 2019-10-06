package com.mateuszmedon.travelapp.service;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import com.mateuszmedon.travelapp.exception.ValidationDataException;
import com.mateuszmedon.travelapp.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip validateAndSave(Trip trip) {
        if(trip.getDateFinnish()
        .isBefore(trip.getDateStart())) {
         throw new ValidationDataException(
                 "return date before departure date");
        }
        return tripRepository.save(trip);
    }
}
