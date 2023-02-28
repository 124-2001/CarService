package com.example.carservice.repository;

import com.example.carservice.model.DTO.ProductDTO;
import com.example.carservice.model.entity.Customer;
import com.example.carservice.model.entity.Order;
import com.example.carservice.model.entity.Product;
import com.example.carservice.model.enums.StatusOrder;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
//    Order findByCustomerAndProductsAndStatusOrder(Customer customer, Set<Product> products, StatusOrder statusOrder);
}
