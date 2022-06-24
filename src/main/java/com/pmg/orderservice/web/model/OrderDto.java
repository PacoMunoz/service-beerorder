package com.pmg.orderservice.web.model;

import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.domain.BeerOrderStatusEnum;
import com.pmg.orderservice.domain.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class OrderDto {

    private String customerRef;

    private Set<BeerOrderLine> beerOrderLines;

    private Customer customer;

    private BeerOrderStatusEnum orderStatus;

}
