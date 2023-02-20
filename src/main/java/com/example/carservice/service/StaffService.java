package com.example.carservice.service;

import com.example.carservice.model.entity.Staff;
import com.example.carservice.repository.OrderRepository;
import com.example.carservice.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StaffService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    StaffRepository staffRepository;
}
