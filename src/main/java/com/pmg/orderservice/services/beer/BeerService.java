package com.pmg.orderservice.services.beer;

import com.pmg.brewery.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    Optional<BeerDto> getBeerByBeerId(UUID beerId);

    Optional<BeerDto> getBeerByUpc(String upc);

}
