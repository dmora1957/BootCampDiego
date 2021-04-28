package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.entities.Dairy;

public interface IDairyService {
    DairyDTO save(DairyDTO dentist);
    void delete(Long id);
    Iterable<DairyDTO> findAll();
    DairyDTO findById(Long id);
}
