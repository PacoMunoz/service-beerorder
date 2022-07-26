package com.pmg.orderservice.services.beer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerServiceTest {

    @Autowired
    private BeerService beerService;

    @Test
    void getBeerByBeerId() {

        beerService.getBeerByUpc("34");
        System.out.println("ya");

    }

    @Test
    void getBeerByUpc() {
    }
}
