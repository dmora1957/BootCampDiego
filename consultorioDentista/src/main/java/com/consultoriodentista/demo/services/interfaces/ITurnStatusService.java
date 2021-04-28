package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.TurnStatusDTO;
import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.TurnStatus;

public interface ITurnStatusService {
    TurnStatusDTO save(TurnStatusDTO dentist);
    void delete(Long id);
    Iterable<TurnStatusDTO> findAll();
    TurnStatusDTO findById(Long id);
}
