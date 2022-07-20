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
@AllArgsConstructor
@Builder
public class BeerOrder extends BaseEntity{

    private String customerRef;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private Set<BeerOrderLine> beerOrderLines;

    private BeerOrderStatusEnum orderStatusEnum = BeerOrderStatusEnum.NEW;

    private String orderStatusCallbackUrl;

}
