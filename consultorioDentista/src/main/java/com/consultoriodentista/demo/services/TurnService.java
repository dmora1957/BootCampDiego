package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import com.consultoriodentista.demo.repositories.IPatientRepository;
import com.consultoriodentista.demo.repositories.ITurnRepository;
import com.consultoriodentista.demo.services.interfaces.ITurnService;
import com.consultoriodentista.demo.services.interfaces.ITurnStatusService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TurnService implements ITurnService {

    private ITurnRepository repo;
    private ModelMapper mapper = new ModelMapper();

    public TurnService(ITurnRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public TurnDTO save(TurnDTO dentist) {
        Turn dairy = mapper.map(dentist, Turn.class);
        var result =  this.repo.save(dairy);
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
