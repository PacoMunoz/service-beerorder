package com.pmg.orderservice.web.mapper;

import com.pmg.brewery.model.BeerOrderDto;
import com.pmg.orderservice.domain.BeerOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrder beerOrderDtoToBeerOrder(BeerOrderDto beerOrderDto);

    @Mapping(source = "customer.id", target = "customerId")
    BeerOrderDto beerOrderToBeerOrderDto(BeerOrder beerOrder);
}
