package com.pmg.orderservice.services;

import com.pmg.model.CustomerPagedList;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomerPagedList getAll(Pageable pageable);
}
