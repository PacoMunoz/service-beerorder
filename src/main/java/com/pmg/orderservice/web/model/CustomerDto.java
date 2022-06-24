package com.pmg.orderservice.web.model;

import com.pmg.orderservice.domain.BeerOrder;

import java.util.Set;
import java.util.UUID;

public class CustomerDto {

    private String customerName;

    private UUID apiKey;

    private Set<BeerOrder> beerOrders;
}
