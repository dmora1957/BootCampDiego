package com.diploma.demo.Services;

import com.diploma.demo.dtos.DiplomaDto;
import com.diploma.demo.dtos.EstudianteDto;

public class DiplomaServices {

    public static DiplomaDto getDiploma(EstudianteDto estudiante)
    {
        int total = 0;
        for (var asig:estudiante.getAsignaturas()) {
            total+=asig.getNota();
        }

        int promedio = total/estudiante.getAsignaturas().size();
        String msg = "";
        if(promedio > 9)
        {
            msg = "Felicitaciones";
        }
        return new DiplomaDto(estudiante.getNombre(),msg, promedio);
    }
}
