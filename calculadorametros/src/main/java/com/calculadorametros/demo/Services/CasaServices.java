package com.calculadorametros.demo.Services;

import com.calculadorametros.demo.dto.CasaDto;
import com.calculadorametros.demo.dto.CasayAreaDto;
import com.calculadorametros.demo.dto.CasayValorDto;
import com.calculadorametros.demo.dto.HabitacionyAreaDto;

import java.util.ArrayList;
import java.util.List;

public class CasaServices {

    public static CasayAreaDto getAreaTotal(CasaDto unaCasa) {
    int total=0;
        for (var h:unaCasa.getHabitaciones()) {
            total+=h.getArea();
        }
        return  new CasayAreaDto(unaCasa.getNombre(), total);
    }

    public static CasayValorDto getValorTotal(CasaDto unaCasa) {

        var areaTotal = getAreaTotal(unaCasa);
        return new CasayValorDto(unaCasa.getNombre(),areaTotal.getArea()*800);
    }

    public static HabitacionyAreaDto getHabitacionGrande(CasaDto unaCasa) {
        var habGrande = new HabitacionyAreaDto("",0);
        for (var h:unaCasa.getHabitaciones()) {
            if(h.getArea()>habGrande.getArea())
            {
                habGrande = new HabitacionyAreaDto(h.getNombre(),h.getArea());
            }
        }
        return  habGrande;
    }

    public static List<HabitacionyAreaDto> getAreaPorHabitacion(CasaDto unaCasa) {
        var habitaciones = new ArrayList<HabitacionyAreaDto>();
        for (var h:unaCasa.getHabitaciones()) {
            habitaciones.add(new HabitacionyAreaDto(h.getNombre(),h.getArea()));
        }
        return  habitaciones;
    }
}
