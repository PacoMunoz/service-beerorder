package com.pmg.orderservice.services.beer;

import com.pmg.brewery.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerServiceTest {

    @Autowired
    private BeerService beerService;

    @Test
    void getBeerByBeerId() {

        // beerService.getBeerByUpc("34");
       /* Optional<BeerDto> a = beerService.getBeerByBeerId(UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb"));
        a.ifPresent( beerDto -> {
            beerDto.toString();
        });*/


    }

    @Test
    void getBeerByUpc() {
    }


}
