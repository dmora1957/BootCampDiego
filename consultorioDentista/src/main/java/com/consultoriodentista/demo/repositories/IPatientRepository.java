package com.consultoriodentista.demo.repositories;

import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
