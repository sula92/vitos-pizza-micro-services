package com.vitospizza.pizzaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PizzaRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
