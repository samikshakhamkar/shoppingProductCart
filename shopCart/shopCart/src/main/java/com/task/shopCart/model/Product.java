package com.task.shopCart.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "p_name")
    private String name;


    @Column(name = "p_price")
    private double price;

    @Column(name = "p_descript")
    private String description;

    @Column(name = "p_quantity")
    private Integer qty;

    @Column(name = "addOn")
    private String added_on;
}
