package com.mateuszmedon.travelapp.entity.trip;

import com.mateuszmedon.travelapp.entity.Airport;
import com.mateuszmedon.travelapp.entity.City;
import com.mateuszmedon.travelapp.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Where {

    @ManyToOne
    private City cityWhere;
    @ManyToOne
    private Hotel hotelWhere;
    @ManyToOne
    private Airport airportWhere;



}
