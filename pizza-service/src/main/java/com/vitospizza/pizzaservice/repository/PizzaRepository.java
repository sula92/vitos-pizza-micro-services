package com.vitospizza.pizzaservice.repository;

import com.vitospizza.pizzaservice.model.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepository extends MongoRepository<Pizza,String> {
}
