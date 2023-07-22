package com.vitospizza.pizzaservice.controller;

import com.vitospizza.pizzaservice.dto.PizzaRequest;
import com.vitospizza.pizzaservice.dto.PizzaResponse;
import com.vitospizza.pizzaservice.exception.PizzaNotFoundException;
import com.vitospizza.pizzaservice.model.Pizza;
import com.vitospizza.pizzaservice.service.PizzaService;
import com.vitospizza.pizzaservice.util.StandardResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/pizza")
@Slf4j
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<StandardResponse> createPizza(@RequestBody PizzaRequest pizzaRequest) {
        log.trace("PizzaController - createPizza - Pizza {}", pizzaRequest);
        PizzaResponse PizzaResponse = pizzaService.createPizza(pizzaRequest);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Pizza Created Successfully", pizzaRequest), HttpStatus.CREATED
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PizzaResponse> getAllProducts() {
        return pizzaService.getAllPizza();
    }

}
