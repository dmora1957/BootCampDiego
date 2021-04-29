package com.consultoriodentista.demo.services.interfaces;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import com.consultoriodentista.demo.exceptions.*;

import java.text.ParseException;
import java.util.List;

public interface ITurnService {
    TurnDTO save(TurnDTO dentist) throws DairyNotFoundException, PatientNotFoundException, TurnStatusValidationNotFoundException;
    void delete(Long id);
    Iterable<TurnDTO> findAll();
    Iterable<TurnDTO> findAllByStatus(Long statusId) throws TurnNotFoundException;
    TurnDTO findById(Long id);
    void changeStatus(Long id, Long statusId) throws TurnNotFoundException, TurnStatusValidationNotFoundException, TurnStatusNotFoundException;
    List<PatientDTO> findPatientsByDate(String stringDate) throws ParseException;
    Iterable<TurnDTO> findAllByStatusAndDate(Long statusId, String date) throws TurnNotFoundException, ParseException;
    Iterable<TurnDTO> findTurnsByDentist(Long id) throws DentistNotFoundException;
}
