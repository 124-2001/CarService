package com.example.carservice.model.entity;

import com.example.carservice.model.enums.StatusOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(mappedBy = "orders")
    private Set<Staff> staffs;
    @ManyToMany(mappedBy = "orders")
    private Set<Product> products;
    @ManyToMany(mappedBy = "orders")
    private Set<Services> services;
    private String note;
    @Column(name = "time_order")
    private Date timeOrder;
    @Column(name = "time_estimate")
    private Date timeEstimate;
    private StatusOrder statusOrder;
    @Column(name = "total_price")
    private float totalPrice;
    private String assignment;

}
