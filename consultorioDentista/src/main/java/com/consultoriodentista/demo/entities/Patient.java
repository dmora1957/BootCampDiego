package com.consultoriodentista.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String address;
    private String dni;
    private Date birthDate;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "patient")
    private Set<Turn> turns;
}
