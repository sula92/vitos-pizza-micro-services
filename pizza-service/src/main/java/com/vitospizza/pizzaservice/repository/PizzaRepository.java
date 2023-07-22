package com.vitospizza.pizzaservice.repository;

import com.vitospizza.pizzaservice.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,String> {
}
