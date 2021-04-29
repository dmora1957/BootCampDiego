package com.consultoriodentista.demo.services;

import com.consultoriodentista.demo.dtos.DairyDTO;
import com.consultoriodentista.demo.dtos.DentistDTO;
import com.consultoriodentista.demo.dtos.PatientDTO;
import com.consultoriodentista.demo.entities.Dentist;
import com.consultoriodentista.demo.entities.Patient;
import com.consultoriodentista.demo.repositories.IDentistRepository;
import com.consultoriodentista.demo.repositories.IPatientRepository;
import com.consultoriodentista.demo.services.interfaces.IPatientService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IPatientService {

    private IPatientRepository repo;
    @Autowired
    private ModelMapper mapper;

    public PatientService(IPatientRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public PatientDTO save(PatientDTO dentist) {
        Patient dairy = mapper.map(dentist, Patient.class);
        var result =  this.repo.save(dairy);
        return mapper.map(result, PatientDTO.class);
    }

    @Override
    public void delete(Long id) {
        this.repo.deleteById(id);
    }

    @Override
    public Iterable<PatientDTO> findAll() {
        List<Patient> result = this.repo.findAll();
        Iterable<PatientDTO> dairies = mapper.map(result, new TypeToken<ArrayList<PatientDTO>>() {}.getType());
        return dairies;
    }

    @Override
    public PatientDTO findById(Long id) {
        var result =  this.repo.findById(id).orElse(null);
        return mapper.map(result, PatientDTO.class);
    }
}
