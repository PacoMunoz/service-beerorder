package com.pmg.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BeerOrderLine extends BaseEntity {

    @Builder
    public BeerOrderLine(UUID id, Long version, Timestamp createDate, Timestamp lastModifiedDate,
                         BeerOrder beerOrder, UUID beerId, String upc, Integer orderQuantity,
                         Integer quantityAllocated) {
        super(id, version, createDate, lastModifiedDate);
        this.beerOrder = beerOrder;
        this.beerId = beerId;
        this.upc = upc;
        this.orderQuantity = orderQuantity;
        this.quantityAllocated = quantityAllocated;
    }

    private BeerOrder beerOrder;

    private UUID beerId;

    private String upc;

    private Integer orderQuantity = 0;

    private Integer quantityAllocated = 0;

}
