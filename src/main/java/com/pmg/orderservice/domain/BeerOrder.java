package com.pmg.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class BeerOrder extends BaseEntity{

    /*
        MAPSTRUT note
        -------------

        If you want builder can access attributes from BaseEntity you must create a constructor
        with all attributes incluyendo super class attributes.
     */
    @Builder
    public BeerOrder(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String customerRef, Customer customer, Set<BeerOrderLine> beerOrderLines, BeerOrderStatusEnum orderStatusEnum, String orderStatusCallbackUrl) {
        super(id, version, createdDate, lastModifiedDate);
        this.customerRef = customerRef;
        this.customer = customer;
        this.beerOrderLines = beerOrderLines;
        this.orderStatusEnum = orderStatusEnum;
        this.orderStatusCallbackUrl = orderStatusCallbackUrl;
    }

    private String customerRef;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private Set<BeerOrderLine> beerOrderLines;

    private BeerOrderStatusEnum orderStatusEnum = BeerOrderStatusEnum.NEW;

    private String orderStatusCallbackUrl;

}
