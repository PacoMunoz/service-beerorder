package com.pmg.orderservice.web.mapper;



import com.pmg.brewery.model.BeerOrderDto;
import com.pmg.orderservice.domain.BeerOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    /*
    Interesante ver como BeerOrder contiene el customer y un customerRef, BeerOrderDto no tiene el customer, pero tiene
    un customerId y un customerRef, por lo que en este mapeo solo se transpasa el customerRef.
            ¿Seria el customerRef suficiente en la transformacion?
     */

    BeerOrder beerOrderDtoToBeerOrder(BeerOrderDto beerOrderDto);

    @Mapping(source = "beerOrderLines", target = "beerOrderLines", ignore = true)
    @Mapping(source = "createdDate", target = "createdDate")
    BeerOrder beerOrderDtoToBeerOrderIgnoreLines(BeerOrderDto beerOrderDto);


    @Mapping(source = "customer.id", target = "customerId")
    BeerOrderDto beerOrderToBeerOrderDto(BeerOrder beerOrder);
}
