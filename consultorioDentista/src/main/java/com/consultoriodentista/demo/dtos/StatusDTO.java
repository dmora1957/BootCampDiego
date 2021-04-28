package com.consultoriodentista.demo.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class StatusDTO {
    public double code;
    public String message;
}
