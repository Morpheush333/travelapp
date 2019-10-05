package com.mateuszmedon.travelapp.entity.payment;


import com.mateuszmedon.travelapp.entity.BaseEntity;
import com.mateuszmedon.travelapp.entity.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase extends BaseEntity {

    @OneToMany
    private List<Member> members;

    private Double amount;



}
