package com.desafioproductos.demo.controllers;

import com.desafioproductos.demo.dtos.CustomerDto;
import com.desafioproductos.demo.dtos.CustomerFilterDto;
import com.desafioproductos.demo.dtos.FilterDto;
import com.desafioproductos.demo.exceptions.*;
import com.desafioproductos.demo.services.ArticleService;
import com.desafioproductos.demo.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService _service;

    public CustomerController(CustomerService service) {
        this._service = service;
    }

    /**
     * Search customer by filter and order, none of the filters are required
     * @param name the customer name filter
     * @param province the province name filter
     * @param order order type of the collection response: 0 Name Asc, 1 Name Desc
     * @return 200 status code with the customer collection
     * @throws FileLoadException 500 status code with the message of the error while loading data file
     * @throws FilterNotValidException 400 status code with filter validation error
     * @throws EmptyResponseException 200 status code with the message "there is no data to return"
     */
    @GetMapping
    public ResponseEntity getCustomers(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String province,
                                      @RequestParam(required = false) Integer order) throws GenericException {
        return new ResponseEntity<>(this._service.getCustomers(new CustomerFilterDto(name,province,order)), HttpStatus.OK);
    }

    /**
     * Add new customer
     * @param newCustomer the customer name filter
     * @return 200 status code
     * @throws DocumentAlreadyExistsException 422 status code if cant be added
     */
    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDto newCustomer) throws GenericException {
        return new ResponseEntity<>(this._service.addCustomer(newCustomer), HttpStatus.OK);
    }

}
