package com.vitospizza.orderservice.service.impl;

import com.vitospizza.orderservice.dto.OrderLineItemsDto;
import com.vitospizza.orderservice.dto.OrderRequest;
import com.vitospizza.orderservice.model.Order;
import com.vitospizza.orderservice.model.OrderLineItems;
import com.vitospizza.orderservice.repository.OrderRepository;
import com.vitospizza.orderservice.service.OrderService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient webClient;

    @Override
    public String placeOrder(OrderRequest orderRequest) {

        if(!checkUserLogin()){
            log.info("User has not login");
            return "Please Login to Place an Order";
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .collect(Collectors.toList());

        orderRepository.save(order);

        return null;
    }

    @SneakyThrows
    public Boolean checkUserLogin() {
        /*return webClientBuilder.build().post()
                .uri("http://localhost:8090/api/users/login")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();*/
        return webClient.get()
                .uri("/api/test")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

    }

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
