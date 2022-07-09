package com.pmg.orderservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OrderPagedList extends PageImpl<BeerOrderDto> {


    public OrderPagedList(List<BeerOrderDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public OrderPagedList(List<BeerOrderDto> content) {
        super(content);
    }
}

