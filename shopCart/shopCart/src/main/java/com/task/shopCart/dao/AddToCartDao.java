package com.task.shopCart.dao;

import com.task.shopCart.dto.AddCartDto;
import com.task.shopCart.model.AddToCart;

import java.util.List;
import java.util.Optional;

public interface AddToCartDao {
    Optional<AddToCart> getCartItemsById(int userId, int productId);

    void save(AddToCart addToCart);

    List<AddCartDto> getCartByuserId(int userId);

    List<AddCartDto> deleteProductById(int userId, int cartId);
}
