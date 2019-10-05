package com.mateuszmedon.travelapp.entity.payment;

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
public class Member extends BaseEntity {

    private String firstName;

    private String LastName;




}
