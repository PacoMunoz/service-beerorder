package com.pmg.orderservice.web.model;

import com.pmg.orderservice.domain.BeerOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@Builder
public class OrderLineDto {

    private BeerOrder beerOrder;

    private UUID beerId;

    private String upc;

    private Integer orderQuantity;

    private Integer quantityAllocated;
}
