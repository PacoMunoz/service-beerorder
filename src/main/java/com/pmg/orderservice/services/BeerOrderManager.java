package com.pmg.orderservice.services;

import com.pmg.orderservice.domain.BeerOrder;

import java.util.UUID;

public interface BeerOrderManager {

    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerId, Boolean isValid);

    void beerOrderAllocationPassed(BeerOrder beerOrder);

    void beerOrderAllocationPendingInventory(BeerOrder beerOrder);

    void beerOrderAllocationFailed(BeerOrder beerOrder);

    void beerOrderPickedUp(UUID id);

    void cancelOrder(UUID id);

}
