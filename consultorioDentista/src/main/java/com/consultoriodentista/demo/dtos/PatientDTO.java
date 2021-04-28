package com.consultoriodentista.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String dni;
    private Date birthDate;
    private String phone;
    private String email;
}
