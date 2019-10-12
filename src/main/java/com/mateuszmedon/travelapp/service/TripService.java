package com.mateuszmedon.travelapp.service;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import com.mateuszmedon.travelapp.exception.NotFoundExceptionId;
import com.mateuszmedon.travelapp.exception.ValidationDataException;
import com.mateuszmedon.travelapp.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public Trip validateAndSave(Trip trip) {
        if(trip.getDateFinnish()
        .isBefore(trip.getDateStart())) {
            String message = String.format("Return date (%s) is before departure date (%s)",
                    trip.getDateFinnish(),
                    trip.getDateStart());
         throw new ValidationDataException(message);
        }
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        if(!tripRepository.existsById(id)) {
//          TODO: throw not found exception
            throw new NotFoundExceptionId(
                    "this id doesn't exist for delete");
        }
            tripRepository.deleteById(id);

    }

    public Trip getById(Long id) {

        Optional<Trip> trip = tripRepository.findById(id);

        if (!trip.isPresent()) {
//            operate if trip is empty
//            TODO: throw not found exception
            throw new NotFoundExceptionId(
                    "this id doesn't exist for find");
        }
        return trip.get();
    }

    public Trip update(Trip trip, Long id) {
//        TODO remove code duplication, DRY!!!
        if(!tripRepository.existsById(id)) {
//            TODO exception throw not found exception
        }
        trip.setId(id);
        return tripRepository.save(trip);
    }
}
