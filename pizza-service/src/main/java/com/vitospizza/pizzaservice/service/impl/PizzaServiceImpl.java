package com.vitospizza.pizzaservice.service.impl;

import com.vitospizza.pizzaservice.dto.PizzaRequest;
import com.vitospizza.pizzaservice.dto.PizzaResponse;
import com.vitospizza.pizzaservice.exception.PizzaNotFoundException;
import com.vitospizza.pizzaservice.model.Pizza;
import com.vitospizza.pizzaservice.service.PizzaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaServiceImpl implements PizzaService {
    @Override
    public PizzaResponse createPizza(PizzaRequest pizzaRequest) {
        return null;
    }

    @Override
    public List<PizzaResponse> getAllPizza() {
        return null;
    }

    @Override
    public PizzaResponse getPizzaById() throws PizzaNotFoundException {
        return null;
    }

    private PizzaResponse mapToProductResponse(Pizza pizza) {
        return PizzaResponse.builder()
                .id(pizza.getId())
                .name(pizza.getName())
                .description(pizza.getDescription())
                .price(pizza.getPrice())
                .build();
    }
}
