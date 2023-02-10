package com.osiris.order.service.domain.entity;

import com.osiris.domain.entity.AggregateRoot;
import com.osiris.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
