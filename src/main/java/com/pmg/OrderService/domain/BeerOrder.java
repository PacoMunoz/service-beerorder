package com.pmg.OrderService.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerOrder extends BaseEntity{

    private String customerRef;

    private Set<BeerOrderLine> beerOrderLines;

    private Customer customer;

    private BeerOrderStatusEnum orderStatus;

    private String orderStatusCallbackUrl;



}
