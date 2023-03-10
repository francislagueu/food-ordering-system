package com.osiris.order.service.dataaccess.customer.mapper;

import com.osiris.domain.valueobject.CustomerId;
import com.osiris.order.service.dataaccess.customer.entity.CustomerEntity;
import com.osiris.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity){
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}
