package com.osiris.order.service.domain.ports.output.message.publisher.payment;

import com.osiris.domain.event.DomainEventPublisher;
import com.osiris.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
