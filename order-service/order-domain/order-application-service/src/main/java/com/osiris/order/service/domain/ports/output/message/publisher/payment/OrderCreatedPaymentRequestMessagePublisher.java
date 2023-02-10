package com.osiris.order.service.domain.ports.output.message.publisher.payment;

import com.osiris.domain.event.DomainEventPublisher;
import com.osiris.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
