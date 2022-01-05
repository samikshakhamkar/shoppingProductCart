package com.task.shopCart.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "u_id")
    private Integer uId;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "p_address")
    private String address;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "pwd")
    private String password;

    @Column(name = "mobno")
    private Integer mobile;
}

