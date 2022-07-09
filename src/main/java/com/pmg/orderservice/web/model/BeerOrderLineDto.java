package com.pmg.orderservice.web.model;

import com.pmg.orderservice.domain.BeerOrder;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrderLineDto {

    private BeerOrder beerOrder;

    private UUID beerId;

    private String upc;

    private Integer orderQuantity;

    private Integer quantityAllocated;
}
