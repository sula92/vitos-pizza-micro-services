package com.vitospizza.pizzaservice.service.impl;

import com.vitospizza.pizzaservice.dto.PizzaRequest;
import com.vitospizza.pizzaservice.dto.PizzaResponse;
import com.vitospizza.pizzaservice.exception.PizzaNotFoundException;
import com.vitospizza.pizzaservice.model.Pizza;
import com.vitospizza.pizzaservice.repository.PizzaRepository;
import com.vitospizza.pizzaservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public PizzaResponse createPizza(PizzaRequest pizzaRequest) {
        Pizza pizza = Pizza.builder()
                .id(UUID.randomUUID().toString())
                .name(pizzaRequest.getName())
                .description(pizzaRequest.getDescription())
                .price(pizzaRequest.getPrice())
                .build();

        Pizza savedPizza=pizzaRepository.save(pizza);
        log.info("Product {} is saved", pizza.getId());
        return mapToPizzaResponse(savedPizza);
    }

    @Override
    public List<PizzaResponse> getAllPizza() {

        return pizzaRepository.findAll()
                .stream()
                .map(this::mapToPizzaResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaResponse getPizzaById(String id) throws PizzaNotFoundException {
        return mapToPizzaResponse(pizzaRepository.findById(id).get());
    }

    private PizzaResponse mapToPizzaResponse(Pizza pizza) {
        return PizzaResponse.builder()
                .id(pizza.getId())
                .name(pizza.getName())
                .description(pizza.getDescription())
                .price(pizza.getPrice())
                .build();
    }
}
