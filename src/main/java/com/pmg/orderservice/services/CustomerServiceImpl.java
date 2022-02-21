package com.pmg.orderservice.services;

import com.pmg.model.CustomerPagedList;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerPagedList getAll(Pageable pageable) {
        return null;
    }
}
