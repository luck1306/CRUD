package com.example.crud.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(nullable = false)
    private String email;

    @Builder
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email= email;
    }

    public void update(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

}
