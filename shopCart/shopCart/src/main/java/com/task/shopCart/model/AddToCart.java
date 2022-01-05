package com.task.shopCart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class AddToCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" )
    private Product product;
    private Integer qty;
    private Double price;
    private User user_id;

    @Column(updatable = false,insertable = false )
    private  String added_date;

    @Transient
    private String productName;



}

