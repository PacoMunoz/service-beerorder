package com.pmg.orderservice.web.model;

import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.domain.BeerOrderStatusEnum;
import com.pmg.orderservice.domain.Customer;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrderDto {

    private String customerRef;

    private Set<BeerOrderLine> beerOrderLines;

    private Customer customer;

    private BeerOrderStatusEnum orderStatus;

}
