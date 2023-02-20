package com.example.carservice.model.request;

import com.example.carservice.model.DTO.StaffDTO;
import com.example.carservice.model.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class InsertStaffRequest {
    private Order order;
    private Set<StaffDTO> staffDTOS;
}
