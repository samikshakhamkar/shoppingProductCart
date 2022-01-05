package com.task.shopCart.dao.daoimpl;

import com.task.shopCart.dao.AddToCartDao;
import com.task.shopCart.dto.AddCartDto;
import com.task.shopCart.model.AddToCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class CartDaoImpl implements AddToCartDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Optional<AddToCart> getCartItemsById(int userId, int productId) {
        Session session=null;
        List list=null;

        try
        {
            session=sessionFactory.openSession();
            Transaction t1=session.beginTranction();
            Query query= session.createQuery("Select addToCart From AddToCart addToCart WHERE addToCart.product.id=:product_id and addCart.user_id=:user_id");
            query.setParameter(@Param("user_id")Integer user_id, @Param("product_id")Integer product_id);

            list=query.list();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }

        return list;

    }



    @Override
    public List<AddCartDto> getCartByuserId(int userId) {

        try
        {
            session=sessionFactory.openSession();
            Transaction t1=session.beginTranction();
            Query query= session.createQuery("Select addToCart From AddToCart addToCart WHERE  addCart.user_id=:user_id");
            query.setParameter(@Param("user_id")Integer user_id);

            list=query.list();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }

        return list;

    }

    @Override
    public List<AddCartDto> deleteProductById(int userId, int cartId);
    {
        session=sessionFactory.openSession();
        Transaction t1=session.beginTranction();
        Query query= session.createQuery("delete addToCart From AddToCart addToCart WHERE addToCart.cart.id=:id and addCart.user_id=:user_id");
        query.setParameter(@Param("user_id")Integer user_id, @Param("id")Integer id);

        list=query.list();

    }catch(Exception e){
        e.printStackTrace();
        return null;
    }finally {
        session.close();
    }

        return list;

    }
    
}
