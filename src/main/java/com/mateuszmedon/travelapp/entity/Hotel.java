package com.mateuszmedon.travelapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hotels")
public class Hotel extends BaseEntity{

    private String name;

    private String description;

    private Integer stars;

    @ManyToOne
    private City city;
}
