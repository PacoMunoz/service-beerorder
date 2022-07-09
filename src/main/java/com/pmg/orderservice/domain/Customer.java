package com.pmg.orderservice.domain;

import lombok.*;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Builder
    public Customer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                    String customerName, UUID apiKey, Set<BeerOrder> beerOrders) {
        super(id, version, createdDate, lastModifiedDate);
        this.customerName = customerName;
        this.apiKey = apiKey;
        this.beerOrders = beerOrders;
    }

    private String customerName;

    private UUID apiKey;

    private Set<BeerOrder> beerOrders;
}
