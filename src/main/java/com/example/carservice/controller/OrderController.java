package com.example.carservice.controller;

import com.example.carservice.model.DTO.OrderDTO;
import com.example.carservice.model.entity.Order;
import com.example.carservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order/get-all")
    public String getAllOrders(Model model){
        List<Order> orders= orderRepository.findAll();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/order/page/create")
    public String createOrderPage(Model model){
        return "index";
    }

    @PostMapping("order/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO dto){
        return ResponseEntity.ok("ok");
    }
}
