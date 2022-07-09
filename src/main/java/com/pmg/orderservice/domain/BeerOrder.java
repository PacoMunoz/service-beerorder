package com.pmg.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class BeerOrder extends BaseEntity{

    public BeerOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                     String customerRef, Customer customer, Set<BeerOrderLine> beerOrderLines,
                     BeerOrderStatusEnum orderStatusEnum, String orderStatusCallbackUrl) {
        super(id, version, createdDate, lastModifiedDate);
        this.customerRef = customerRef;
        this.customer = customer;
        this.beerOrderLines = beerOrderLines;
        this.orderStatusEnum = orderStatusEnum;
        this.orderStatusCallbackUrl = orderStatusCallbackUrl;
    }

    private String customerRef;

    private Customer customer;

    private Set<BeerOrderLine> beerOrderLines;

    private BeerOrderStatusEnum orderStatusEnum = BeerOrderStatusEnum.NEW;

    private String orderStatusCallbackUrl;

}
