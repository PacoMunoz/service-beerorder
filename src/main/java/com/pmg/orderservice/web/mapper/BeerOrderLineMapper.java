package com.pmg.orderservice.web.mapper;


import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = DateMapper.class)
public interface BeerOrderLineMapper {

    BeerOrderLineDto beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine);

    BeerOrderLine beerOrderLineDtoToBeerOrderLine(BeerOrderLineDto beerOrderLineDto);

}
