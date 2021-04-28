package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.repositories.IDiaryRepository;
import com.consultoriodentista.demo.services.interfaces.IDairyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DairyService implements IDairyService {

    private IDiaryRepository repo;

    private ModelMapper mapper = new ModelMapper();

    public DairyService(IDiaryRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public DairyDTO save(DairyDTO dentist) {
        Dairy dairy = mapper.map(dentist, Dairy.class);
        var result =  this.repo.save(dairy);
        return mapper.map(result, DairyDTO.class);
    }

    @Override
    public void delete(Long id) {
        this.repo.deleteById(id);
    }

    @Override
    public Iterable<DairyDTO> findAll() {
        var result = this.repo.findAll();
        Iterable<DairyDTO> dairies = mapper.map(result, new TypeToken<ArrayList<DairyDTO>>() {}.getType());
        return dairies;
    }

    @Override
    public DairyDTO findById(Long id) {
        var result =  this.repo.findById(id).orElse(null);
        return mapper.map(result, DairyDTO.class);
    }
}
