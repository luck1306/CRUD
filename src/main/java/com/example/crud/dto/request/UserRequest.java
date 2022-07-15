package com.example.crud.dto.request;

import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public class UserRequest {

    @Size(max = 20)
    private String name;

    @Size(min = 8, max = 16)
    private String password;

    private String email;
}
