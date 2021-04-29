package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import com.consultoriodentista.demo.exceptions.*;
import com.consultoriodentista.demo.helpers.DataUtils;
import com.consultoriodentista.demo.helpers.DateHelper;
import com.consultoriodentista.demo.repositories.IPatientRepository;
import com.consultoriodentista.demo.repositories.ITurnRepository;
import com.consultoriodentista.demo.services.interfaces.ITurnService;
import com.consultoriodentista.demo.repositories.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TurnService implements ITurnService {

    private ITurnRepository repo;
    @Autowired
    private IDiaryRepository diaryRepo;
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    private ITurnStatusRepository statusRepository;
    @Autowired
    private ModelMapper mapper;

    public TurnService(ITurnRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public TurnDTO save(TurnDTO turn) throws DairyNotFoundException, PatientNotFoundException, TurnStatusValidationNotFoundException {
        Dairy query = diaryRepo.findById(turn.getDairyId()).orElse(null);

        if(query == null){
            throw new DairyNotFoundException("Dairy id not found");
        }

        if(!DataUtils.compareDate(query.getStartTime(),query.getEndTime(),turn.getDay())){
            throw new DairyNotFoundException("Selected day is not available");
        }
        if(!patientRepository.existsById(turn.getPatientId())){
            throw  new PatientNotFoundException("Patient not found");
        }

        validateMinutes(turn);
        turn.setTurnStatusId(2L);
        Turn turn1 = mapper.map(turn, Turn.class);
        var result =  this.repo.save(turn1);
        return mapper.map(result, TurnDTO.class);
    }

    public void validateMinutes(TurnDTO turn) throws DairyNotFoundException, PatientNotFoundException, TurnStatusValidationNotFoundException {
        var result = repo.findByDairyId(turn.getDairyId());
        var fromDate = new Date(turn.getDay().getTime() - 3600 * 1000);;
        var toDate = new Date(turn.getDay().getTime() + 3600 * 1000);;

        result = result.stream().filter(t -> t.getDay().compareTo(fromDate) >= 0 && t.getDay().compareTo(toDate) <= 0)
                .collect(Collectors.toList());

        if(!result.isEmpty()){
            throw new TurnStatusValidationNotFoundException("Turn already taken");
        }
    }

    @Override
    public void delete(Long id) {
        this.repo.deleteById(id);
    }

    @Override
    public Iterable<TurnDTO> findAll() {
        var result = this.repo.findAll();
        Iterable<TurnDTO> dairies = mapper.map(result, new TypeToken<ArrayList<TurnDTO>>() {}.getType());
        return dairies;
    }

    @Override
    public Iterable<TurnDTO> findAllByStatus(Long statusId) throws TurnNotFoundException {
        var status = this.statusRepository.findById(statusId).orElse(null);
        if(status == null)
            throw new TurnNotFoundException("Not found");

        var result = this.repo.findByTurnStatus(status);
        Iterable<TurnDTO> dairies = mapper.map(result, new TypeToken<ArrayList<TurnDTO>>() {}.getType());
        return dairies;
    }

    @Override
    public Iterable<TurnDTO> findAllByStatusAndDate(Long statusId, String stringDate) throws TurnNotFoundException, ParseException {
        var status = this.statusRepository.findById(statusId).orElse(null);
        if(status == null)
            throw new TurnNotFoundException("Not found");
        var dateFrom = DateHelper.parseStringToDate(stringDate);
        GregorianCalendar calTo = new GregorianCalendar();
        calTo.setTime(dateFrom);
        calTo.add(Calendar.DATE, 1);
        var dateTo = calTo.getTime();

        var result = this.repo.findByTurnStatusAndDayGreaterThanEqualAndDayLessThan(status, dateFrom,dateTo);
        Iterable<TurnDTO> dairies = mapper.map(result, new TypeToken<ArrayList<TurnDTO>>() {}.getType());
        return dairies;
    }

    @Override
    public Iterable<TurnDTO> findTurnsByDentist(Long id) throws DentistNotFoundException {
        var dentist = this.dentistRepository.findById(id).orElse(null);
        if(dentist == null)
            throw new DentistNotFoundException("Not found");
        var dairies = this.diaryRepo.findByDentist(dentist);
        var turnsResult = this.repo.findByDairyIn(dairies);
        Iterable<TurnDTO> turns = mapper.map(turnsResult, new TypeToken<ArrayList<TurnDTO>>() {}.getType());
        return turns;
    }

    @Override
    public TurnDTO findById(Long id) {
        var result =  this.repo.findById(id).orElse(null);
        return mapper.map(result, TurnDTO.class);
    }

    /**
     * Ejercicio 1 practico 29/4
     */
    @Override
    public List<PatientDTO> findPatientsByDate(String stringDate) throws ParseException {
        var dateFrom = DateHelper.parseStringToDate(stringDate);
        GregorianCalendar calTo = new GregorianCalendar();
        calTo.setTime(dateFrom);
        calTo.add(Calendar.DATE, 1);
        var dateTo = calTo.getTime();

        var result =  this.repo.findByDayGreaterThanEqualAndDayLessThan(dateFrom,dateTo);

        List<Patient> patients = result.stream().map(Turn::getPatient).collect(Collectors.toList());

        return mapper.map(patients, new TypeToken<ArrayList<PatientDTO>>() {}.getType());
    }

    // dateFrom 23-04-2021 00.00.00
    // dateTo 24-04-2021 00.00.00
    @Override
    public void changeStatus(Long id, Long statusId) throws TurnNotFoundException, TurnStatusValidationNotFoundException, TurnStatusNotFoundException {

        var turn = repo.findById(id).orElse(null);

        if(turn == null){
            throw new TurnNotFoundException("Turn not found");
        }

        var status = statusRepository.findById(statusId).orElse(null);
        if(status == null){
            throw new TurnStatusNotFoundException("Status not found");
        }

        if(status.getId().equals(turn.getTurnStatus().getId())){
            throw new TurnStatusValidationNotFoundException("Status already set");
        }

        turn.setTurnStatus(status);
        repo.save(turn);
    }
}
