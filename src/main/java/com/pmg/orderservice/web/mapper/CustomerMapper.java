package com.pmg.orderservice.web.mapper;


import com.pmg.model.CustomerDto;
import com.pmg.orderservice.domain.Customer;
import org.mapstruct.Mapper;

@Mapper
public class CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);


}
