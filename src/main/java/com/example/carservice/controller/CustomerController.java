package com.example.carservice.controller;

import com.example.carservice.model.DTO.OrderDTO;
import com.example.carservice.model.request.InsertServiceRequest;
import com.example.carservice.model.request.InsertStaffRequest;
import com.example.carservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
    @Autowired
    OrderService orderService;
    @PostMapping("/order/insert")
    public ResponseEntity<?> insertOrder(@RequestBody OrderDTO newOrder){
        return ResponseEntity.ok(orderService.insertOrder(newOrder));
    }

//    @PostMapping("/order/insert-staff")
//    public ResponseEntity<?> insertStaff(@RequestBody InsertStaffRequest staffRequest){
//        return ResponseEntity.ok(orderService.insertStaffInOrder(staffRequest.getOrder(),staffRequest.getStaffDTOS()));
//    }
//
//    @PostMapping("order/update-service")
//    public ResponseEntity<?> updateServiceOrder(@RequestBody InsertServiceRequest serviceRequest){
//        return ResponseEntity.ok(orderService.updateService(serviceRequest.getOrder(),serviceRequest.getServicesDTO()));
//    }
}
