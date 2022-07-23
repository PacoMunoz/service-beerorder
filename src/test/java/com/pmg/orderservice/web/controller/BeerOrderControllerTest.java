package com.pmg.orderservice.web.controller;


import com.pmg.brewery.model.BeerOrderDto;
import com.pmg.brewery.model.BeerOrderLineDto;
import com.pmg.brewery.model.CustomerDto;
import com.pmg.orderservice.domain.BeerOrder;
import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.domain.BeerOrderStatusEnum;
import com.pmg.orderservice.domain.Customer;
import com.pmg.orderservice.web.mapper.BeerOrderMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BeerOrderMapper.class)
class BeerOrderControllerTest {

    private BeerOrderMapper beerOrderMapper = Mappers.getMapper(BeerOrderMapper.class);

    Customer customer1 = new Customer();
    Customer customer2 = new Customer();
    BeerOrder beerOrder1 = new BeerOrder();
    BeerOrder beerOrder2 = new BeerOrder();
    BeerOrderLine beerOrderLine1 = new BeerOrderLine();
    BeerOrderLine beerOrderLine2 = new BeerOrderLine();
    BeerOrderLine beerOrderLine3 = new BeerOrderLine();
    CustomerDto customerDto1 = new CustomerDto();
    CustomerDto customerDto2 = new CustomerDto();
    BeerOrderDto beerOrderDto1 = new BeerOrderDto();
    BeerOrderDto beerOrderDto2 = new BeerOrderDto();
    BeerOrderLineDto beerOrderLineDto1 = new BeerOrderLineDto();
    BeerOrderLineDto beerOrderLineDto2 = new BeerOrderLineDto();
    BeerOrderLineDto beerOrderLineDto3 = new BeerOrderLineDto();


    @BeforeEach
    public void prepare() {
        customer1 = Customer.builder().apiKey(UUID.randomUUID()).customerName("Paco Muñoz").build();

        customerDto1 = CustomerDto.builder().customerName("Paco Muñoz").build();

        beerOrder1 = BeerOrder.builder()
                .orderStatusEnum(BeerOrderStatusEnum.ALLOCATED)
                .customer(customer1)
                .customerRef("23")
                .build();

        beerOrderDto1 = BeerOrderDto.builder()

                .orderStatusCallbackUrl("http://callback.test")
                .customerRef("12-12-1")
                .beerOrderLines(Arrays.asList(beerOrderLineDto1, beerOrderLineDto2, beerOrderLineDto3))
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();

        beerOrderLine1.builder()
                .beerId(UUID.randomUUID())
                .orderQuantity(12)
                .beerOrder(beerOrder1)
                .quantityAllocated(12)
                .build();

        beerOrderLine2.builder()
                .beerId(UUID.randomUUID())
                .orderQuantity(12)
                .beerOrder(beerOrder2)
                .quantityAllocated(12)
                .build();

        beerOrderLine3.builder()
                .beerId(UUID.randomUUID())
                .orderQuantity(12)
                .beerOrder(beerOrder1)
                .quantityAllocated(12)
                .build();

        beerOrderLineDto1 = BeerOrderLineDto.builder()
                .beerId(UUID.randomUUID())
                .beerName("HOla")
                .beerStyle("Pura")
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .orderQuantity(12)
                .price(BigDecimal.valueOf(10.23))
                .quantityAllocated(3)
                .id(UUID.randomUUID())
                .upc("sdaf")
                .version(1)
                .build();

        beerOrderLineDto2 = BeerOrderLineDto.builder()
                .beerId(UUID.randomUUID())
                .beerName("HOla")
                .beerStyle("Pura")
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .orderQuantity(12)
                .price(BigDecimal.valueOf(10.23))
                .quantityAllocated(3)
                .id(UUID.randomUUID())
                .upc("sdaf")
                .version(1)
                .build();

        beerOrderLineDto3 = BeerOrderLineDto.builder()
                .beerId(UUID.randomUUID())
                .beerName("HOla")
                .beerStyle("Pura")
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .orderQuantity(12)
                .price(BigDecimal.valueOf(10.23))
                .quantityAllocated(3)
                .id(UUID.randomUUID())
                .upc("sdaf")
                .version(1)
                .build();

    }

    @Test
    void getOrders() {

        BeerOrder beerorder = beerOrderMapper.beerOrderDtoToBeerOrder(beerOrderDto1);

        assertEquals(beerorder.getCustomer().getId(), beerOrderDto1.getCustomerId());

    }

    @Test
    void placeOrder() {
    }

    @Test
    void getOrder() {
    }

    @Test
    void pickupOrder() {
    }
}
