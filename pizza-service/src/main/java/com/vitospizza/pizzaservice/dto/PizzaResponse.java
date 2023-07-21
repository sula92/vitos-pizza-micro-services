package com.vitospizza.pizzaservice.dto;

import com.vitospizza.pizzaservice.model.Pizza;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PizzaResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
