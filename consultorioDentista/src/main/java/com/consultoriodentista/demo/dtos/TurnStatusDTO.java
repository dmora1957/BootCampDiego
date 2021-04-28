package com.consultoriodentista.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
public class TurnStatusDTO {

    private Long id;
    private String name;
    private String description;
}
