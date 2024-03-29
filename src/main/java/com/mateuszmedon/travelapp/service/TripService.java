package com.mateuszmedon.travelapp.service;

import com.mateuszmedon.travelapp.entity.trip.Trip;
import com.mateuszmedon.travelapp.exception.NotFoundExceptionId;
import com.mateuszmedon.travelapp.exception.ValidationDataException;
import com.mateuszmedon.travelapp.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private static final String TRIP_NOT_FOUND = "Trip with id %s not found.";

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }

    public Page<Trip> getAllTrips(Pageable pageable){
        return tripRepository.findAll(pageable);
    }

    public Trip validateAndSave(Trip trip) {
        if(trip.getDateFinnish()
        .isBefore(trip.getDateStart())) {
            String message = String.format("Return date %s is before departure date (%s)",
                    trip.getDateFinnish(),
                    trip.getDateStart());
         throw new ValidationDataException(message);
        }
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        if(!tripRepository.existsById(id)) {
            throw new NotFoundExceptionId(
                    String.format(TRIP_NOT_FOUND, id));
        }
            tripRepository.deleteById(id);
    }

    public Trip getById(Long id) {

        Optional<Trip> trip = tripRepository.findById(id);

        if (!trip.isPresent()) {
//            operate if trip is empty
            throw new NotFoundExceptionId(
                    String.format(TRIP_NOT_FOUND, id));
        }
        return trip.get();
    }

    public Trip update(Trip trip, Long id) {
//        TODO remove code duplication, DRY!!!
        if(!tripRepository.existsById(id)) {
            throw new NotFoundExceptionId(String.format(TRIP_NOT_FOUND, id));
        }
        trip.setId(id);
        return tripRepository.save(trip);
    }
}
