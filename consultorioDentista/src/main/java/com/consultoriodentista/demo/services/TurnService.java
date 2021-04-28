package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.exceptions.DairyNotFoundException;
import com.consultoriodentista.demo.exceptions.PatientNotFoundException;
import com.consultoriodentista.demo.helpers.DataUtils;
import com.consultoriodentista.demo.repositories.IPatientRepository;
import com.consultoriodentista.demo.repositories.ITurnRepository;
import com.consultoriodentista.demo.services.interfaces.ITurnService;
import com.consultoriodentista.demo.repositories.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

@Service
public class TurnService implements ITurnService {

    private ITurnRepository repo;
    @Autowired
    private IDiaryRepository diaryRepo;
    @Autowired
    private IPatientRepository patientRepository;

    private ModelMapper mapper = new ModelMapper();

    public TurnService(ITurnRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public TurnDTO save(TurnDTO turn) throws DairyNotFoundException, PatientNotFoundException {
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
        turn.setTurnStatusId(2L);
        Turn turn1 = mapper.map(turn, Turn.class);
        var result =  this.repo.save(turn1);
        return mapper.map(result, TurnDTO.class);
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
    public TurnDTO findById(Long id) {
        var result =  this.repo.findById(id).orElse(null);
        return mapper.map(result, TurnDTO.class);
    }
}
