package com.vitospizza.orderservice.service;

import com.vitospizza.orderservice.dto.OrderLineItemsDto;
import com.vitospizza.orderservice.dto.OrderRequest;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Lazy
public interface OrderService {

    public String placeOrder(List<OrderLineItemsDto> orderLineItemsDtos, String sessionId);
    public Boolean checkUserLogin(String sessionId);

}
