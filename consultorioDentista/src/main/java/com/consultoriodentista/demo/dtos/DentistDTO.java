package com.consultoriodentista.demo.dtos;

import com.consultoriodentista.demo.entities.Dairy;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class DentistDTO {

    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String dni;
    private Date birthDate;
    private String phone;
    private String email;
    //private String codeMp
    //private Set<DairyDTO> dairies;
}
