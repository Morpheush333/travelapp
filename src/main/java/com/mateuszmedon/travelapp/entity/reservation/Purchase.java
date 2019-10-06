package com.mateuszmedon.travelapp.entity.reservation;


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
    private List<PersonalData> members;

    @ManyToOne
    private Trip trip;

    public Double getTotalPrice() {
        return members.stream()
                .mapToDouble(member -> member.getIsAdult()
                        ? trip.getAdultPrice()
                        : trip.getKidPrice())
                .sum();
    }

//    public Double getTotalPriceInClassic() {
//        double price = 0;
//
//        for (int i = 0; i <= members.size(); i++) {
//            if (members.get(i).getIsAdult()) {
//                price += trip.getAdultPrice();
//            } else {
//                price += trip.getKidPrice();
//            }
//        }
//        return price;
}

