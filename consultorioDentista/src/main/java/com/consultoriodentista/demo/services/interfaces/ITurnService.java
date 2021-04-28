package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import com.consultoriodentista.demo.exceptions.DairyNotFoundException;
import com.consultoriodentista.demo.exceptions.PatientNotFoundException;

public interface ITurnService {
    TurnDTO save(TurnDTO dentist) throws DairyNotFoundException, PatientNotFoundException;
    void delete(Long id);
    Iterable<TurnDTO> findAll();
    TurnDTO findById(Long id);
}
