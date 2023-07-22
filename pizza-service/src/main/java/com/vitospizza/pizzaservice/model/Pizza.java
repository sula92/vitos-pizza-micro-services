package com.vitospizza.pizzaservice.model;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Pizza implements SuperModel {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
