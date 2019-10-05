package com.mateuszmedon.travelapp.entity.trip;

import com.mateuszmedon.travelapp.entity.Airport;
import com.mateuszmedon.travelapp.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class From {

    @ManyToOne
    private City cityFrom;
    @ManyToOne
    private Airport airportFrom;


}
