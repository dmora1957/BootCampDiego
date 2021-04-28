package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.entities.Dentist;
import com.consultoriodentista.demo.entities.Patient;

public interface IPatientService {
    PatientDTO save(PatientDTO dentist);
    void delete(Long id);
    Iterable<PatientDTO> findAll();
    PatientDTO findById(Long id);
}
