package com.vitospizza.pizzaservice.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
