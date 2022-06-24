package com.pmg.orderservice.domain;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
@Builder
public class Customer extends BaseEntity {

    private String customerName;

    private UUID apiKey;

    private Set<BeerOrder> beerOrders;
}
