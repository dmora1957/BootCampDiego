package com.appconsultoriomysql.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Privilege(String name) {
        this.name = name;
        roles = new ArrayList<>();
    }

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}
