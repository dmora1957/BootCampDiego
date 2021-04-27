package com.example.ormdemo.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name="document", unique = true)
    private String document;

    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy="author")
    private Set<Publication> publications = new HashSet<Publication>();
}
