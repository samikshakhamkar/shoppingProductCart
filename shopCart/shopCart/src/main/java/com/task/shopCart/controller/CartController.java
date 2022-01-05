package com.task.shopCart.controller;

import java.util.HashMap;
import java.util.List;
import com.task.shopCart.dto.AddCartDto;
import com.task.shopCart.dto.ResponseVO;
import com.task.shopCart.model.AddToCart;
import com.task.shopCart.service.AddToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private AddToCartService addToCartService;

    @RequestMapping(value = "AddProductToCart", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO<AddCartDto>addToCartCtrl(@RequestBody  HashMap<String,String> addCartRequest) throws Exception {

        AddCartDto addCartDto=new AddCartDto();
        ResponseVO<AddCartDto> responseVO = new ResponseVO<>();

        String keys[]={"productId", "userId", "qty","price"};

        int productId=Integer.parseInt(addCartRequest.get("productId"));
        int userId=Integer.parseInt(addCartRequest.get("userId"));
        int qty=Integer.parseInt(addCartRequest.get("qty"));
        Double price=Double.parseDouble(addCartRequest.get("price"));
        Boolean flag =false;

           List<AddCartDto> list=addToCartService.addCartProductById(productId,userId,qty,price);

        if(flag) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Insert Successfully...");
            responseVO.setResult(addCartDto);
        }
        else {

            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Insert Failed..");
            responseVO.setResult(addCartDto);

        }
        return responseVO;
    }

    @RequestMapping(value = "getCartByUserId", method = RequestMethod.GET)
    @ResponseBody
    public ResponseVO<AddCartDto>getCartCtrl(@RequestBody  HashMap<String,String> getCartRequest) throws Exception {

        AddCartDto addCartDto=new AddCartDto();
        ResponseVO<AddCartDto> responseVO = new ResponseVO<>();
        Boolean flag=false;
        String keys[]= {"userId"};
        List<AddCartDto> list=addToCartService.getCartByUserId(Integer.parseInt(getCartRequest.get("userId")));
        if(flag) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Insert Successfully...");
            responseVO.setResult(addCartDto);
        }
        else {

            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Insert Failed..");
            responseVO.setResult(addCartDto);

        }
        return responseVO;

    }

    @RequestMapping(value = "removeProductToCart", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseVO<AddCartDto>removeFromCartCtrl(@RequestBody  HashMap<String,String> removeCartRequest) throws Exception {

        AddCartDto addCartDto=new AddCartDto();
        ResponseVO<AddCartDto> responseVO = new ResponseVO<>();

        String keys[]={"cartId", "userId"};

        Boolean flag =false;

        List<AddCartDto> list=addToCartService.removeProductById(Integer.parseInt(removeCartRequest.get("userId")),Integer.parseInt(removeCartRequest.get("cartId")));

        if(flag) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Delete Successfully...");
            responseVO.setResult(addCartDto);
        }
        else {

            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Delete Failed..");
            responseVO.setResult(addCartDto);

        }
        return responseVO;
    }



    }





