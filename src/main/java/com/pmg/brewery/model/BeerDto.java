package com.pmg.brewery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id = null;
    private Integer version = null;

    private OffsetDateTime createdDate = null;
    private OffsetDateTime lastModifiedDate = null;

    private String beerName;
    private String beerStyle;
    private String upc;
    private String quantityOnHand;

    private BigDecimal price;
}
