package com.example.carservice.model.DTO;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class StaffDTO {
    @NotNull
    private String name;
    @NotNull
    private String phone;
}
