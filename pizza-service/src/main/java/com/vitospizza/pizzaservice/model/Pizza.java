package com.vitospizza.pizzaservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Pizza implements SuperModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
