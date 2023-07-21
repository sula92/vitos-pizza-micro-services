package com.vitospizza.pizzaservice.advice;


import com.vitospizza.pizzaservice.exception.PizzaNotFoundException;
import com.vitospizza.pizzaservice.util.StandardResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PizzaAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(
                new StandardResponse(405, "HTTP  Method Not Suitable", null), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = PizzaNotFoundException.class)
    public ResponseEntity<StandardResponse> handlePizzaNotFoundException(PizzaNotFoundException PizzaNotFoundException) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Pizza Not Found", null), HttpStatus.NOT_FOUND
        );
    }
}
