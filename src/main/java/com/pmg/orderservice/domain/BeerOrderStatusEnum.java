package com.pmg.orderservice.domain;

/**
 * Distintas fases por las que puede pasar una orden
 */
public enum  BeerOrderStatusEnum {
    NEW, VALIDATED, VALIDATION_PENDING, VALIDATION_EXCEPTION,
    ALLOCATION_PENDING, ALLOCATED, ALLOCATION_EXCEPTION, CANCELLED,
    PENDING_INVENTORY, PICKED_UP, DELIVERED, DELIVERY_EXCEPTION
}
