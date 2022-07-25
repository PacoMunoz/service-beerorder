package com.pmg.orderservice.web.controller;


import com.pmg.brewery.model.BeerOrderDto;
import com.pmg.brewery.model.BeerOrderLineDto;
import com.pmg.brewery.model.CustomerDto;
import com.pmg.orderservice.domain.BeerOrder;
import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.domain.BeerOrderStatusEnum;
import com.pmg.orderservice.domain.Customer;
import com.pmg.orderservice.web.mapper.BeerOrderLineMapper;
import com.pmg.orderservice.web.mapper.BeerOrderMapper;
import com.pmg.orderservice.web.mapper.DateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerOrderControllerTest {

    //@InjectMocks
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

        BeerOrderLineMapper beerOrderLineMapper = Mappers.getMapper(BeerOrderLineMapper.class);
        ReflectionTestUtils.setField(beerOrderMapper, "beerOrderLineMapper", beerOrderLineMapper);

        DateMapper dateMapper = Mappers.getMapper(DateMapper.class);
        ReflectionTestUtils.setField(beerOrderMapper, "dateMapper", dateMapper);

        customer1 = Customer.builder().apiKey(UUID.randomUUID()).customerName("Paco Muñoz").build();

        customerDto1 = CustomerDto.builder().customerName("Paco Muñoz").build();

        beerOrder1 = BeerOrder.builder()
                .orderStatusEnum(BeerOrderStatusEnum.ALLOCATED)
                .customer(customer1)
                .customerRef("23")
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
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

        beerOrderDto1 = BeerOrderDto.builder()
                .id(UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb"))
                .orderStatusCallbackUrl("http://callback.test")
                .customerRef("12-12-1")
                .beerOrderLines(Arrays.asList(beerOrderLineDto1, beerOrderLineDto2, beerOrderLineDto3))
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .orderStatusEnum(BeerOrderStatusEnum.NEW.toString())
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

    }

    @Test
    void beerOrderMapping() {


        BeerOrder beerOrder = beerOrderMapper.beerOrderDtoToBeerOrder(beerOrderDto1);

        BeerOrder beerorder = beerOrderMapper.beerOrderDtoToBeerOrderIgnoreLines(beerOrderDto1);
        assertEquals(beerorder.getCustomerRef(), beerOrderDto1.getCustomerRef());

        BeerOrderDto beerOrderDto = beerOrderMapper.beerOrderToBeerOrderDto(beerOrder1);
        assertEquals(beerorder.getCustomer().getId(), beerOrderDto.getCustomerId());
    }


    @Test
    void getOrders() {

        /*BeerOrderLine beerOrderLine = beerOrderLineMapper.beerOrderLineDtoToBeerOrderLine(beerOrderLineDto1);

        BeerOrder beerorder = beerOrderMapper.beerOrderDtoToBeerOrderIgnoreLines(beerOrderDto1);

        assertEquals(beerorder.getCustomerRef(), beerOrderDto1.getCustomerRef());*/

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
