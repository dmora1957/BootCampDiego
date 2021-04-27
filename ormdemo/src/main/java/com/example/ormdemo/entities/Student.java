package com.example.ormdemo.entities;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "dni", nullable = false, unique = true)
    private String dni;
    private String firstName;
    private String lastName;

}
