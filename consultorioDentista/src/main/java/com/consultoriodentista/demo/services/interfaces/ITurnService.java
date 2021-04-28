package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;

public interface ITurnService {
    TurnDTO save(TurnDTO dentist);
    void delete(Long id);
    Iterable<TurnDTO> findAll();
    TurnDTO findById(Long id);
}
