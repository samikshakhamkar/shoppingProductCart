package com.task.shopCart.service;

import java.util.List;

public interface AddToCartService {

    List<AddCartDto> removeProductById(int userId, int cartId) throws Exception;


    List<AddCartDto> addCartProductById(int productId, int userId, int qty, double price) throws Exception;

    List<AddCartDto> getCartByUserId(int userId);
}
