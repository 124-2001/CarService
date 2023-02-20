package com.example.carservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String address;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
