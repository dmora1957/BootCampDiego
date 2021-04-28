package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.entities.Dentist;

public interface IDentistService {
    DentistDTO save(DentistDTO dentist);
    void delete(Long id);
    Iterable<DentistDTO> findAll();
    DentistDTO findById(Long id);
}
