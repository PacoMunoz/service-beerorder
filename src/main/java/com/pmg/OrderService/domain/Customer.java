package com.pmg.OrderService.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity {

    private String customerName;

    private UUID apiKey;

    private Set<BeerOrder> beerOrders;
}
