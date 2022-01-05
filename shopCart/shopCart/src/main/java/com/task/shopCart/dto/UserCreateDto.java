package com.task.shopCart.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserCreateDto {

    private Integer uId;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private String password;

    private Integer mobile;
}
