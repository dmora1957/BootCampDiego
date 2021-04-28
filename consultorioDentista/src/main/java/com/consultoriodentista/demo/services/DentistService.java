package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.entities.Dairy;
import com.consultoriodentista.demo.entities.Dentist;
import com.consultoriodentista.demo.repositories.IDentistRepository;
import com.consultoriodentista.demo.repositories.IDiaryRepository;
import com.consultoriodentista.demo.services.interfaces.IDentistService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DentistService implements IDentistService {

    private IDentistRepository repo;
    private ModelMapper mapper = new ModelMapper();

    public DentistService(IDentistRepository repo)
    {
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
}
