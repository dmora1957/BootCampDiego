package com.appconsultoriomysql.demo.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @Column(nullable = false, unique = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dni;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

}
