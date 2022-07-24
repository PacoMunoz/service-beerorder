package com.pmg.orderservice.web.mapper;


import com.pmg.brewery.model.BeerOrderLineDto;
import com.pmg.orderservice.domain.BeerOrderLine;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerOrderLineMapper {

    BeerOrderLineDto beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine);

    BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDto beerOrderLineDto);

}
