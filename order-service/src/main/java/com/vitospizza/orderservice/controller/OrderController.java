package com.vitospizza.orderservice.controller;

import com.vitospizza.orderservice.dto.OrderRequest;
import com.vitospizza.orderservice.service.OrderService;
import com.vitospizza.orderservice.util.StandardResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "order", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "order")
    @Retry(name = "order")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));
    }

    @GetMapping
    public Boolean isUserLogin(){
        return orderService.checkUserLogin();

    }

    public CompletableFuture<ResponseEntity<StandardResponse>> fallBackMethodOrder() {
        log.warn("OrderController - fallBackMethodOrder");
        return CompletableFuture.supplyAsync(() -> new ResponseEntity<StandardResponse>(
                new StandardResponse(503, "User Service Unavailable", null), HttpStatus.SERVICE_UNAVAILABLE
        ));
    }
}
