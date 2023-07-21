package com.vitospizza.pizzaservice.service;

import com.vitospizza.pizzaservice.dto.PizzaRequest;
import com.vitospizza.pizzaservice.dto.PizzaResponse;
import com.vitospizza.pizzaservice.exception.PizzaNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Lazy
public interface PizzaService {

    PizzaResponse createPizza(PizzaRequest pizzaRequest);
    List<PizzaResponse> getAllPizza();
    PizzaResponse getPizzaById(String id) throws PizzaNotFoundException;
}
