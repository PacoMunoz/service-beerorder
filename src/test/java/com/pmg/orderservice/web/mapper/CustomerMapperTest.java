package com.pmg.orderservice.web.mapper;

import com.pmg.brewery.model.CustomerDto;
import com.pmg.orderservice.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerMapperTest {

    private CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    private CustomerDto customerDto;
    private Customer customer;

    @BeforeEach
    void init() {
        DateMapper dateMapper = Mappers.getMapper(DateMapper.class);
        ReflectionTestUtils.setField(customerMapper, "dateMapper", dateMapper);
        initMocks();
    }

    @Test
    void customerToCustomerDto() {

        CustomerDto result = customerMapper.customerToCustomerDto(customer);

        Assertions.assertEquals(result.getId(), customer.getId());
        Assertions.assertEquals(result.getVersion(), customer.getVersion());
        Assertions.assertEquals(result.getCustomerName(), customer.getCustomerName());
    }

    @Test
    void customerDtoToCustomer() {

        Customer result = customerMapper.customerDtoToCustomer(customerDto);

        Assertions.assertEquals(result.getId(), customerDto.getId());
        Assertions.assertEquals(result.getVersion(), customerDto.getVersion());
        Assertions.assertEquals(result.getCustomerName(), customerDto.getCustomerName());
    }

    private void initMocks() {
        customer = Customer.builder()
                .customerName("Pepe")
                .apiKey(UUID.randomUUID())
                .id(UUID.randomUUID())
                .version(12L)
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
                .build();
        customerDto = CustomerDto.builder()
                .customerName("Pepe")
                .id(UUID.randomUUID())
                .version(2L)
                .createDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();
    }
}
