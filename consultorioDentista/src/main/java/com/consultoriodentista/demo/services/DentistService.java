package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.entities.Dentist;
import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.helpers.DateHelper;
import com.consultoriodentista.demo.repositories.IDentistRepository;
import com.consultoriodentista.demo.repositories.IDiaryRepository;
import com.consultoriodentista.demo.repositories.ITurnRepository;
import com.consultoriodentista.demo.services.interfaces.IDentistService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistService implements IDentistService {

    private IDentistRepository repo;
    private ITurnRepository turnRepo;
    @Autowired
    private ModelMapper mapper;

    public DentistService(IDentistRepository repo, ITurnRepository turnRepo)
    {
        this.turnRepo = turnRepo;
        this.repo = repo;
    }
    @Override
    public DentistDTO save(DentistDTO dentist) {
        Dentist dairy = mapper.map(dentist, Dentist.class);
        var result =  this.repo.save(dairy);
        return mapper.map(result, DentistDTO.class);
    }

    @Override
    public void delete(Long id) {
       this.repo.deleteById(id);
    }

    @Override
    public Iterable<DentistDTO> findAll() {

        var result =  this.repo.findAll();
        Iterable<DentistDTO> dentists = mapper.map(result, new TypeToken<ArrayList<DentistDTO>>() {}.getType());
        return dentists;
    }

    @Override
    public DentistDTO findById(Long id) {
        var result =  this.repo.findById(id).orElse(null);
        return mapper.map(result, DentistDTO.class);
    }

    @Override
    public List<DentistDTO> findDentistWithMoreThanTwoTurns(String date) throws ParseException {
        var dateFrom = DateHelper.parseStringToDate(date);
        GregorianCalendar calTo = new GregorianCalendar();
        calTo.setTime(dateFrom);
        calTo.add(Calendar.DATE, 1);
        var dateTo = calTo.getTime();

        var result =  this.turnRepo.groupByDairy(dateFrom,dateTo);

        List<Dentist> patients = result.stream().map(Dairy::getDentist).collect(Collectors.toList());

        return mapper.map(patients, new TypeToken<ArrayList<DentistDTO>>() {}.getType());
    }
}
