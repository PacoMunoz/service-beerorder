package com.pmg.orderservice.web.model;

import com.pmg.orderservice.domain.BeerOrder;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String customerName;

    private UUID apiKey;

    private Set<BeerOrder> beerOrders;
}
