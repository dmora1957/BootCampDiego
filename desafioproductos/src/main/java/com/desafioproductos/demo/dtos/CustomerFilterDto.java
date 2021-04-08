package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerFilterDto {
    private String Name;
    private String Province;
    private Integer order;
}
