package com.pmg.orderservice.web.mapper;

import com.pmg.orderservice.domain.BeerOrder;
import com.pmg.orderservice.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrder beerOrderDtoToBeerOrder(BeerOrderDto beerOrderDto);

    BeerOrderDto beerOrderToBeerOrderDto(BeerOrder beerOrder);
}
