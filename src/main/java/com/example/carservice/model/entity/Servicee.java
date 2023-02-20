package com.example.carservice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Servicee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    @ManyToMany
    @JoinTable(name = "service_order",joinColumns = @JoinColumn(name = "service_id"),inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders;
}
