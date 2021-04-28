package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.TurnDTO;
import com.consultoriodentista.demo.dtos.TurnStatusDTO;
import com.consultoriodentista.demo.entities.Turn;
import com.consultoriodentista.demo.entities.TurnStatus;
import com.consultoriodentista.demo.repositories.ITurnRepository;
import com.consultoriodentista.demo.repositories.ITurnStatusRepository;
import com.consultoriodentista.demo.services.interfaces.ITurnStatusService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TurnStatusService implements ITurnStatusService {

    private ITurnStatusRepository repo;
    private ModelMapper mapper = new ModelMapper();

    public TurnStatusService(ITurnStatusRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public TurnStatusDTO save(TurnStatusDTO dentist) {
        TurnStatus dairy = mapper.map(dentist, TurnStatus.class);
        var result =  this.repo.save(dairy);
        return mapper.map(result, TurnStatusDTO.class);
    }

    @Override
    public void delete(Long id) {
        this.repo.deleteById(id);
    }

    @Override
    public Iterable<TurnStatusDTO> findAll() {
        var result = this.repo.findAll();
        Iterable<TurnStatusDTO> dairies = mapper.map(result, new TypeToken<ArrayList<TurnStatusDTO>>() {}.getType());
        return dairies;
    }

    @Override
    public TurnStatusDTO findById(Long id) {
        var result =  this.repo.findById(id).orElse(null);
        return mapper.map(result, TurnStatusDTO.class);
    }
}
