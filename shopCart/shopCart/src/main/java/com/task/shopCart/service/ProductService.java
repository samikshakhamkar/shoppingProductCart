package com.task.shopCart.service;

import com.task.shopCart.dto.ProductDto;

import com.task.shopCart.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product getProductByID(int productId);
    
    

