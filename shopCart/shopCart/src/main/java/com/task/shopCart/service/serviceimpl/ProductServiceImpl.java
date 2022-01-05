package com.task.shopCart.service.serviceimpl;

import com.task.shopCart.dao.ProductDao;
import com.task.shopCart.dto.ProductDto;
import com.task.shopCart.model.Category;
import com.task.shopCart.model.Product;
import com.task.shopCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;






}
