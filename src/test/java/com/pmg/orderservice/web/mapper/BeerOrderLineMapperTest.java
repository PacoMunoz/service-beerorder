package com.pmg.orderservice.web.mapper;

import com.pmg.brewery.model.BeerOrderLineDto;
import com.pmg.orderservice.domain.BeerOrder;
import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.domain.BeerOrderStatusEnum;
import com.pmg.orderservice.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;


@SpringBootTest
class BeerOrderLineMapperTest {

    private BeerOrderLineMapper beerOrderLineMapper = Mappers.getMapper(BeerOrderLineMapper.class);

    private BeerOrderLine beerOrderLine;
    private BeerOrderLineDto beerOrderLineDto;
    private BeerOrder beerOrder;
    private Customer customer;


    @BeforeEach
    public void init() {

        // reflection para asignar al beerOrderLineMapperImpl el objeto DateMapper que necesita
        // si no se realiza esta operacion el objeto beerOrderLineMapperImpl tendra su atributo
        // dateMapper a null y no funcionara completamente el mapeo.
        DateMapper dateMapper = Mappers.getMapper(DateMapper.class);
        ReflectionTestUtils.setField(beerOrderLineMapper, "dateMapper", dateMapper);

        beerOrderLineDto = BeerOrderLineDto.builder()
                .beerId(UUID.randomUUID())
                .beerName("HOla")
                .beerStyle("Pura")
                .orderQuantity(12)
                .price(BigDecimal.valueOf(10.23))
                .quantityAllocated(3)
                .id(UUID.randomUUID())
                .upc("0631234200036")
                .version(1)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();

        customer = Customer.builder()
                .apiKey(UUID.randomUUID())
                .customerName("Paco Muñoz").build();

        beerOrder = BeerOrder.builder()
                .orderStatusEnum(BeerOrderStatusEnum.ALLOCATED)
                .customer(customer)
                .customerRef("23")
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
                .build();

        beerOrderLine = BeerOrderLine.builder()
                .id(UUID.randomUUID())
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
                .version(12L)
                .beerId(UUID.randomUUID())
                .orderQuantity(12)
                .beerOrder(beerOrder)
                .quantityAllocated(12)
                .upc("0631234200036")
                .build();

    }


    @Test
    void beerOrderLineToBeerOrderLineDto() {

        BeerOrderLineDto result = beerOrderLineMapper.beerOrderLineToBeerOrderLineDto(beerOrderLine);

        Assertions.assertEquals(beerOrderLine.getId(), result.getId());
        Assertions.assertEquals(beerOrderLine.getUpc(), result.getUpc());
        Assertions.assertEquals(beerOrderLine.getOrderQuantity(), result.getOrderQuantity());
        Assertions.assertEquals(beerOrderLine.getQuantityAllocated(), result.getQuantityAllocated());
        Assertions.assertEquals(beerOrderLine.getVersion(), result.getVersion());

    }

    @Test
    void beerOrderLineDtoToBeerOrderLine() {

        BeerOrderLine result = beerOrderLineMapper.beerOrderLineDtoToBeerOrderLine(beerOrderLineDto);

        Assertions.assertEquals(beerOrderLineDto.getId(), result.getId());
        Assertions.assertEquals(beerOrderLineDto.getUpc(), result.getUpc());
        Assertions.assertEquals(beerOrderLineDto.getVersion().longValue(), result.getVersion());
        Assertions.assertEquals(beerOrderLineDto.getOrderQuantity(), result.getOrderQuantity());
        Assertions.assertEquals(beerOrderLineDto.getQuantityAllocated(), result.getQuantityAllocated());
    }

}
