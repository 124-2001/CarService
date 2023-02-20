package com.example.carservice.model.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ServiceDTO {
    @NotNull
    private String name;
    private float price;
}
