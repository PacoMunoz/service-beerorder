package com.pmg.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Customer extends BaseEntity {

    private String customerName;

    private UUID apiKey;

    @OneToMany
    private Set<BeerOrder> beerOrders;
}
