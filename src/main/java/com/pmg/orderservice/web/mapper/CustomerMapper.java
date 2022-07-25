package com.pmg.orderservice.web.mapper;


import com.pmg.brewery.model.CustomerDto;
import com.pmg.orderservice.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = DateMapper.class)
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

}
