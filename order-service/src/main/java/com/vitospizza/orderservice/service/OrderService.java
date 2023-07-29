package com.vitospizza.orderservice.service;

import com.vitospizza.orderservice.dto.OrderRequest;
import org.springframework.context.annotation.Lazy;

@Lazy
public interface OrderService {

    public String placeOrder(OrderRequest orderRequest);
    public Boolean checkUserLogin();

}
