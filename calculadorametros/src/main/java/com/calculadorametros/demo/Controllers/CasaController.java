package com.calculadorametros.demo.Controllers;

import com.calculadorametros.demo.Services.CasaServices;
import com.calculadorametros.demo.dto.CasaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casa")
public class CasaController {

    @PostMapping("/area")
    public  ResponseEntity getAreaTotal(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(CasaServices.getAreaTotal(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/valor")
    public  ResponseEntity getValorTotal(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(CasaServices.getValorTotal(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/habitacionGrande")
    public  ResponseEntity getHabitacionMasGrande(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(CasaServices.getHabitacionGrande(unaCasa), HttpStatus.OK);
    }

    @PostMapping("/areaHabitacion")
    public  ResponseEntity getAreaPorHabitacion(@RequestBody CasaDto unaCasa)
    {
        return new ResponseEntity(CasaServices.getAreaPorHabitacion(unaCasa), HttpStatus.OK);
    }
}
