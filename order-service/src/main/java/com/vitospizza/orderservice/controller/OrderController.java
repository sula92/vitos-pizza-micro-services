package com.vitospizza.orderservice.controller;

import com.vitospizza.orderservice.dto.OrderLineItemsDto;
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

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    /*@CircuitBreaker(name = "order", fallbackMethod = "fallBackMethodOrder")
    @TimeLimiter(name = "order")
    @Retry(name = "order")*/
    public String placeOrder(
            @RequestBody List<OrderLineItemsDto> orderLineItemsDtos,
            @RequestHeader String sessionId
    ) {
        System.out.println("XXXXXXXXXXXXXXXXXXXxxx"+sessionId);
        log.info("Placing Order"+orderLineItemsDtos.toString());
        return  orderService.placeOrder(orderLineItemsDtos,sessionId);
    }

    @GetMapping
    public Boolean isUserLogin(@RequestHeader String sessionId){
        return orderService.checkUserLogin(sessionId);

    }

    public StandardResponse fallBackMethodOrder() {
        log.warn("OrderController - fallBackMethodOrder");
        return  new StandardResponse(503,"Service Unavailable","");
    }
}
