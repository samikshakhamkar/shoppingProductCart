package com.task.shopCart.service.serviceimpl;

import com.task.shopCart.dao.AddToCartDao;
import com.task.shopCart.dto.AddCartDto;
import com.task.shopCart.model.AddToCart;
import com.task.shopCart.model.Product;
import com.task.shopCart.service.AddToCartService;

import com.task.shopCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartServiceImpl implements AddToCartService {
    @Autowired
    private AddToCartDao addToCartDao;

    @Autowired
    private ProductService productService;




    @Override
    public List<AddCartDto> addCartProductById(int productId, int userId, int qty, double price) throws Exception {
        try {

            if (addToCartDao.getCartItemsById(userId, productId).isPresent()) ;
            {
                throw new Exception("Product is already exist");
            }

            AddToCart addToCart = new AddToCart();
            addToCart.setQty(addToCart.getQty());
            addToCart.setUser_id(addToCart.getUser_id());

            Product product = productService.getPrductBy(productId);
            addToCart.setProduct(addToCart.getProduct());

            addToCart.setPrice(addToCart.getPrice());
            addToCartDao.save(addToCart);
            return this.getCartByUserId(userId);

        } catch (Exception e) {

            e.printStackTrace();
            throw new Exception("Done");
        }
    }

    @Override
    public List<AddCartDto> getCartByUserId(int userId) {


        return addToCartDao.getCartByuserId(userId);
    }

    @Override
    public List<AddCartDto> removeProductById(int userId, int cartId)  {
        addToCartDao.deleteProductById(userId,cartId);
        return this.getCartByUserId(userId);
    }
}












