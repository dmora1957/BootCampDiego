package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.entities.Dentist;

import java.text.ParseException;
import java.util.List;

public interface IDentistService {
    DentistDTO save(DentistDTO dentist);
    void delete(Long id);
    Iterable<DentistDTO> findAll();
    DentistDTO findById(Long id);
    List<DentistDTO> findDentistWithMoreThanTwoTurns(String date) throws ParseException;
}
