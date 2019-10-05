package com.mateuszmedon.travelapp.entity.trip;

import com.mateuszmedon.travelapp.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trip extends BaseEntity {

    @Embedded
    private From from;

    @Embedded
    private Where where;
    private LocalDate dateStart;
    private LocalDate dateFinnish;
//    private Integer totalDay;

    @Enumerated(EnumType.STRING)
    private Catering type;
    private Double adultPrice;
    private Double kidPrice;
    private boolean promotion;
    private Integer adultAvailable;
    private Integer kidAvailable;

    public int getDuration(){
        return Period.between(dateStart, dateFinnish).getDays();
    }




}
