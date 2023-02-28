package com.example.carservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;
    private String status;
    @ManyToMany
    @JoinTable(name = "product_order",joinColumns = @JoinColumn(name = "product_id"),inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
