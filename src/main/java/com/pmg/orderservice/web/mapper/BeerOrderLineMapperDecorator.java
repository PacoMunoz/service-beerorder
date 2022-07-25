package com.pmg.orderservice.web.mapper;


import com.pmg.brewery.model.BeerOrderLineDto;
import com.pmg.orderservice.domain.BeerOrderLine;
import com.pmg.orderservice.services.beer.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

    private BeerOrderLineMapper beerOrderLineMapper;

    @Autowired
    private BeerService beerService;

    @Autowired
    // esta annotation ayuda cuando exiten dos posibles beans candidatos de inyectar.
    // Qualifier(nombreDelBeanAInyectar) soluciona el problema
    @Qualifier("delegate")
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToBeerOrderLineDto(BeerOrderLine beerOrderLine) {
        BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToBeerOrderLineDto(beerOrderLine);

        beerService.getBeerByUpc(beerOrderLine.getUpc()).ifPresent(
                x -> {
                    beerOrderLineDto.setBeerName(x.getBeerName());
                    beerOrderLineDto.setBeerStyle(x.getBeerStyle());
                    beerOrderLineDto.setPrice(x.getPrice());
                    beerOrderLineDto.setBeerId(x.getId());
                }
        );

        return beerOrderLineDto;
    }
}
