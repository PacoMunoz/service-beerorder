package com.pmg.orderservice.web.mapper;

import com.pmg.brewery.model.BeerOrderDto;
import com.pmg.brewery.model.BeerOrderLineDto;
import com.pmg.orderservice.domain.BeerOrder;
import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.domain.BeerOrderStatusEnum;
import com.pmg.orderservice.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BeerOrderMapperTest {

    private BeerOrderMapper beerOrderMapper = Mappers.getMapper(BeerOrderMapper.class);

    private BeerOrder beerOrder;
    private BeerOrderDto beerOrderDto;

    @BeforeEach
    void init() {

        // mediante reflection, seteamos el beerOrderLineMapper attribute a BeerOrderMapperImpl
        BeerOrderLineMapper beerOrderLineMapper = Mappers.getMapper(BeerOrderLineMapper.class);
        ReflectionTestUtils.setField(beerOrderMapper, "beerOrderLineMapper", beerOrderLineMapper);

        DateMapper dateMapper = Mappers.getMapper(DateMapper.class);
        ReflectionTestUtils.setField(beerOrderMapper, "dateMapper", dateMapper);
        ReflectionTestUtils.setField(beerOrderLineMapper, "dateMapper", dateMapper);

        initMocks();
    }

    @Test
    void beerOrderToDto() {
        BeerOrderDto result = beerOrderMapper.beerOrderToBeerOrderDto(beerOrder);

        Assertions.assertEquals(result.getId(), beerOrder.getId());
        Assertions.assertEquals(result.getVersion().toString(), beerOrder.getVersion().toString());
        Assertions.assertEquals(result.getCustomerId(), beerOrder.getCustomer().getId());
        Assertions.assertEquals(result.getBeerOrderLines().size(), beerOrder.getBeerOrderLines().size());
        Assertions.assertEquals(result.getBeerOrderLines().get(0).getBeerId(), beerOrder.getBeerOrderLines().stream().findFirst().get().getId());
        Assertions.assertEquals(result.getBeerOrderLines().get(0).getUpc(), beerOrder.getBeerOrderLines().stream().findFirst().get().getUpc());


    }

    @Test
    void dtoToBeerOrder() {

    }

    private void initMocks() {
        beerOrderDto = BeerOrderDto.builder()
                .id(UUID.randomUUID())
                .version(2)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .beerOrderLines(Arrays.asList(
                        BeerOrderLineDto.builder()
                                .id(UUID.randomUUID())
                                .version(2)
                                .createdDate(OffsetDateTime.now())
                                .lastModifiedDate(OffsetDateTime.now())
                                .beerName("Crus")
                                .beerId(UUID.randomUUID())
                                .beerStyle("ral")
                                .orderQuantity(12)
                                .price(BigDecimal.valueOf(15))
                                .quantityAllocated(12)
                                .upc("hod")
                                .build(),
                        BeerOrderLineDto.builder()
                                .id(UUID.randomUUID())
                                .version(2)
                                .createdDate(OffsetDateTime.now())
                                .lastModifiedDate(OffsetDateTime.now())
                                .beerName("Exte")
                                .beerId(UUID.randomUUID())
                                .beerStyle("Es")
                                .orderQuantity(10)
                                .price(BigDecimal.valueOf(19))
                                .quantityAllocated(12)
                                .upc("hoda")
                                .build()
                ))
                .customerId(UUID.randomUUID())
                .customerRef("werewr")
                .orderStatusEnum("NEW")
                .orderStatusCallbackUrl("http://hola.com")
                .build();

        beerOrder = BeerOrder.builder()
                .id(UUID.randomUUID())
                .version(2L)
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
                .beerOrderLines(Set.of(
                        BeerOrderLine.builder()
                                .id(UUID.randomUUID())
                                .version(12L)
                                .createdDate(Timestamp.from(Instant.now()))
                                .lastModifiedDate(Timestamp.from(Instant.now()))
                                .beerId(UUID.randomUUID())
                                .orderQuantity(12)
                                .quantityAllocated(12)
                                .upc("weqwe")
                                .build(),
                        BeerOrderLine.builder()
                                .id(UUID.randomUUID())
                                .version(10L)
                                .createdDate(Timestamp.from(Instant.now()))
                                .lastModifiedDate(Timestamp.from(Instant.now()))
                                .beerId(UUID.randomUUID())
                                .orderQuantity(1)
                                .quantityAllocated(23)
                                .upc("weqwe")
                                .build()
                        )

                )
                .customer(
                        Customer.builder()
                                .apiKey(UUID.randomUUID())
                                .build()
                )
                .customerRef("wer")
                .orderStatusEnum(BeerOrderStatusEnum.NEW)
                .orderStatusCallbackUrl("http://holas.com")
                .build();
    }

}
