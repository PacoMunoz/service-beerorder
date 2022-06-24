package com.pmg.orderservice.services;

import com.pmg.model.BeerOrderDto;
import com.pmg.model.BeerOrderPagedList;
import com.pmg.orderservice.domain.BeerOrder;
import com.pmg.orderservice.domain.Customer;
import com.pmg.orderservice.repositories.BeerOrderRepository;
import com.pmg.orderservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerOrderServiceImpl implements BeerOrderService{

    private final BeerOrderRepository beerOrderRepository;
    private final CustomerRepository customerRepository;

    @Override
    public BeerOrderPagedList listOrders(UUID customerId, Pageable pageable) {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {

           // Page<BeerOrder> orders = beerOrderRepository.findAllByCustomer(Customer.builder().apiKey(customerId).build(), pageable);

            /*orders
                .getContent()
                .stream()
                .map(BeerOrderMapper::);*/


            // new BeerOrderPagedList(beerOrders,pageable);

            //return new BeerOrderPagedList();


        } else {
            return null;
        }


        return null;
    }

    @Override
    public BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto) {
        return null;
    }

    @Override
    public BeerOrderDto getOrderById(UUID customerId, UUID orderId) {
        return null;
    }

    @Override
    public void pickupOrder(UUID customerId, UUID orderId) {

    }
}
