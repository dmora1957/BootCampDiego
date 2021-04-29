package com.consultoriodentista.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date day;

    @ManyToOne
    @JoinColumn(name = "dairy_id", nullable = false)
    private Dairy dairy;

    @ManyToOne
    @JoinColumn(name = "turn_status_id", nullable = false)
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "reprogrammed_turn_id",  referencedColumnName = "id", nullable = true)
    private Turn reprogrammedTurn;

    @OneToOne(mappedBy = "reprogrammedTurn")
    private Turn oldTurn;

}
