package com.pmg.orderservice.services;

import com.pmg.orderservice.domain.BeerOrder;

import java.util.UUID;

public class BeerOrderManagerImpl implements BeerOrderManager {

    @Override
    public BeerOrder newBeerOrder(BeerOrder beerOrder) {
        return null;
    }

    @Override
    public void processValidationResult(UUID beerId, Boolean isValid) {

    }

    @Override
    public void beerOrderAllocationPassed(BeerOrder beerOrder) {

    }

    @Override
    public void beerOrderAllocationPendingInventory(BeerOrder beerOrder) {

    }

    @Override
    public void beerOrderAllocationFailed(BeerOrder beerOrder) {

    }

    @Override
    public void beerOrderPickedUp(UUID id) {

    }

    @Override
    public void cancelOrder(UUID id) {

    }
}
