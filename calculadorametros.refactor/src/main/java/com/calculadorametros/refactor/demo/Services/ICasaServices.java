package com.calculadorametros.refactor.demo.Services;

import com.calculadorametros.refactor.demo.dto.CasaDto;
import com.calculadorametros.refactor.demo.dto.CasayAreaDto;
import com.calculadorametros.refactor.demo.dto.CasayValorDto;
import com.calculadorametros.refactor.demo.dto.HabitacionyAreaDto;

import java.util.ArrayList;
import java.util.List;

public interface ICasaServices {

    public CasayAreaDto getAreaTotal(CasaDto unaCasa);

    public CasayValorDto getValorTotal(CasaDto unaCasa);

    public CasayValorDto calculate(CasaDto unaCasa);

    public HabitacionyAreaDto getHabitacionGrande(CasaDto unaCasa);

    public List<HabitacionyAreaDto> getAreaPorHabitacion(CasaDto unaCasa);
}
