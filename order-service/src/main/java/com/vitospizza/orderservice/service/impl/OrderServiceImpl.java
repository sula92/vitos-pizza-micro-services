package com.vitospizza.orderservice.service.impl;

import com.vitospizza.orderservice.dto.OrderLineItemsDto;
import com.vitospizza.orderservice.dto.OrderRequest;
import com.vitospizza.orderservice.model.OrderLineItems;
import com.vitospizza.orderservice.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        return null;
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
