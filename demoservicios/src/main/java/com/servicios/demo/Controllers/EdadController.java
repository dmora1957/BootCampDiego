package com.servicios.demo.Controllers;

import com.servicios.demo.services.EdadServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @GetMapping("/{day}/{month}/{year}")
    public int buscar(@PathVariable int day,@PathVariable int month,@PathVariable int year)
    {
        return EdadServices.convertirEdad(day,month,year);
    }

}
