package com.mateuszmedon.travelapp.entity.reservation;

import com.mateuszmedon.travelapp.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonalData extends BaseEntity {

    private String LastName;
    private Boolean isAdult;
}
