package com.example.carservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @ManyToMany
    @JoinTable(name = "staff_order",joinColumns = @JoinColumn(name = "staff_id"),inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders;
}
