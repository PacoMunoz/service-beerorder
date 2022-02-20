package com.pmg.OrderService.web;

import com.pmg.OrderService.domain.BeerOrder;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/customer/{customerId}/")
@RestController
public class BeerOrderController {


    @GetMapping("orders")
    public List<BeerOrder> getOrders(@PathVariable("customerId")UUID customerId){
        return null;

    }

    @PostMapping("orders")
    @ResponseStatus(HttpStatus.CREATED)
    public BeerOrder placeOrder (@PathVariable("customerId")UUID customerId, @RequestBody BeerOrder beerOrder){
        return null;
    }

    @GetMapping("orders/{orderId}")
    public BeerOrder getOrder(@PathVariable("customerId") UUID customerId, @PathVariable("orderId") UUID orderId) {
        return null;
    }

    @PutMapping("orders/{orderId}/pickup")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pickupOrder(@PathVariable("customerId") UUID customerId, @PathVariable("orderId") UUID orderId) {

    }

}
