package com.desafioproductos.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
    private Integer ClientId;
    private String Name;
    private String document;
    private String Province;

    public CustomerDto(int clientId) {
        this.ClientId = clientId;
    }

    public String parseToCsvRow() {
        return String.join(",",ClientId.toString(), Name, document,Province);
    }
}
