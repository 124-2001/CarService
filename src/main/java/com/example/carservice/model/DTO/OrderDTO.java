package com.example.carservice.model.DTO;

import com.example.carservice.model.entity.Servicee;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDTO {
    private CustomerDTO customer;
    private Set<ProductDTO> products;
    private Set<Servicee> servicees;
    private String note;
}
