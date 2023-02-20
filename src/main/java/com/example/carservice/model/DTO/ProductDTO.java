package com.example.carservice.model.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    @NotNull
    private String name;
    @NotNull
    private String color;
}
