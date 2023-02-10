package com.osiris.order.service.dataaccess.restaurant.mapper;

import com.osiris.domain.valueobject.Money;
import com.osiris.domain.valueobject.ProductId;
import com.osiris.domain.valueobject.RestaurantId;
import com.osiris.order.service.dataaccess.restaurant.entity.RestaurantEntity;
import com.osiris.order.service.dataaccess.restaurant.exception.RestaurantDataAccessException;
import com.osiris.order.service.domain.entity.Product;
import com.osiris.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant){
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue()).toList();
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities){
        RestaurantEntity restaurantEntity = restaurantEntities.stream().findFirst().orElseThrow(()->
                new RestaurantDataAccessException("Restaurant could not be found!"));
        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(), new Money(entity.getProductprice()))).toList();

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.isRestaurantActive())
                .build();
    }

}
