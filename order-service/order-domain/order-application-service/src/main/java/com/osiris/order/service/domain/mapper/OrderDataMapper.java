package com.osiris.order.service.domain.mapper;

import com.osiris.domain.valueobject.CustomerId;
import com.osiris.domain.valueobject.Money;
import com.osiris.domain.valueobject.ProductId;
import com.osiris.domain.valueobject.RestaurantId;
import com.osiris.order.service.domain.dto.create.CreateOrderCommand;
import com.osiris.order.service.domain.dto.create.CreateOrderResponse;
import com.osiris.order.service.domain.dto.create.OrderAddress;
import com.osiris.order.service.domain.dto.track.TrackOrderResponse;
import com.osiris.order.service.domain.entity.Order;
import com.osiris.order.service.domain.entity.OrderItem;
import com.osiris.order.service.domain.entity.Product;
import com.osiris.order.service.domain.entity.Restaurant;
import com.osiris.order.service.domain.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderDataMapper {
    
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand){
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem -> new Product(new ProductId(orderItem.getProductId()))).toList())
                .build();
    }
    
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand){
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getOrderAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntitis(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message){
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order){
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntitis(List<com.osiris.order.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream().map(orderItem ->
                OrderItem.builder()
                        .product(new Product(new ProductId(orderItem.getProductId())))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .subTotal(new Money(orderItem.getSubTotal()))
                        .build()).toList();
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(UUID.randomUUID(), orderAddress.getStreet(), orderAddress.getPostalCode(), orderAddress.getCity());
    }

}
