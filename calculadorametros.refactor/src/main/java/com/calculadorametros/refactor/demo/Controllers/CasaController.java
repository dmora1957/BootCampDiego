package com.calculadorametros.refactor.demo.Controllers;

import com.calculadorametros.refactor.demo.Services.CasaServices;
import com.calculadorametros.refactor.demo.dto.CasaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casa")
public class CasaController {

    @Autowired
    private CasaServices casaService;

    @PostMapping("/area")
    public  ResponseEntity getAreaTotal(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(this.casaService.getAreaTotal(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/valor")
    public  ResponseEntity getValorTotal(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(this.casaService.getValorTotal(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/valorRepo")
    public  ResponseEntity getValorTotalRepo(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(this.casaService.calculate(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/habitacionGrande")
    public  ResponseEntity getHabitacionMasGrande(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(this.casaService.getHabitacionGrande(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/areaHabitacion")
    public  ResponseEntity getAreaPorHabitacion(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(this.casaService.getAreaPorHabitacion(unaCasa), HttpStatus.OK);
    }
}
