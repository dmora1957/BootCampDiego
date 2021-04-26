package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterDto {
    private Integer id;
    private String Name;
    private String Category;
    private String Brand;
    private Boolean FreeShipping;
    private String Prestige;
    private Integer order;
}
