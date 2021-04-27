package com.example.ormdemo.entities;

import javax.persistence.*;
import java.time.LocalDate;

public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer version;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @Column(name="publishing_date")
    private LocalDate publishingDate;
}
