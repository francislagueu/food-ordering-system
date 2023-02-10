package com.osiris.order.service.domain.ports.output.message.publisher.restaurantapproval;

import com.osiris.domain.event.DomainEventPublisher;
import com.osiris.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
