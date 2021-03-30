package com.calculadorametros.refactor.demo.Services;

import com.calculadorametros.refactor.demo.dto.*;
import com.calculadorametros.refactor.demo.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasaServices implements ICasaServices {

    @Autowired
    private PriceRepository priceRepository;

    public CasayAreaDto getAreaTotal(CasaDto unaCasa) {
    int total=0;
        for (var h:unaCasa.getHabitaciones()) {
            total+=h.getArea();
        }
        return  new CasayAreaDto(unaCasa.getNombre(), total);
    }

    public CasayValorDto getValorTotal(CasaDto unaCasa) {

        var areaTotal = getAreaTotal(unaCasa);
        return new CasayValorDto(unaCasa.getNombre(),areaTotal.getArea()*800);
    }

    public CasayValorDto calculate(CasaDto unaCasa) {
        PriceDto priceByLocation = priceRepository.findPriceByLocation(unaCasa.getLocation());
        var areaTotal = getAreaTotal(unaCasa);
        return new CasayValorDto(unaCasa.getNombre(),areaTotal.getArea()*(priceByLocation != null ? priceByLocation.getPrice() : 0));
    }

    public HabitacionyAreaDto getHabitacionGrande(CasaDto unaCasa) {
        var habGrande = new HabitacionyAreaDto("",0);
        for (var h:unaCasa.getHabitaciones()) {
            if(h.getArea()>habGrande.getArea())
            {
                habGrande = new HabitacionyAreaDto(h.getNombre(),h.getArea());
            }
        }
        return  habGrande;
    }

    public List<HabitacionyAreaDto> getAreaPorHabitacion(CasaDto unaCasa) {
        var habitaciones = new ArrayList<HabitacionyAreaDto>();
        for (var h:unaCasa.getHabitaciones()) {
            habitaciones.add(new HabitacionyAreaDto(h.getNombre(),h.getArea()));
        }
        return  habitaciones;
    }
}
