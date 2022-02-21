package com.pmg.orderservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BeerOrderLine extends BaseEntity {

    private BeerOrder beerOrder;

    private UUID beerId;

    private String upc;

    private Integer orderQuantity;

    private Integer quantityAllocated;


}
