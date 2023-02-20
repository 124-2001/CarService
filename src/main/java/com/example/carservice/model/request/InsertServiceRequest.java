package com.example.carservice.model.request;

import com.example.carservice.model.DTO.ServiceDTO;
import com.example.carservice.model.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class InsertServiceRequest {
    private Order order;
    private Set<ServiceDTO> servicesDTO;
}
