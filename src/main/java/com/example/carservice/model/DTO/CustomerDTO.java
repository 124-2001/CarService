package com.example.carservice.model.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String phone;
}
