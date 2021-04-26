package com.desafioproductos.demo.repositories.interfaces;

import com.desafioproductos.demo.dtos.CustomerDto;
import com.desafioproductos.demo.dtos.CustomerFilterDto;
import com.desafioproductos.demo.exceptions.GenericException;
import com.mercadolibre.kvsclient.exceptions.KvsException;

import java.util.List;

public interface CustomerRepository {
    List<CustomerDto> getCustomers(CustomerFilterDto filter);
    CustomerDto addCustomer(CustomerDto newCustomer) throws GenericException;
    CustomerDto findCustomerByDocument(String document);
    CustomerDto findCustomerById(Integer id);
    CustomerDto updateCustomer(Integer id, CustomerDto newCustomer) throws KvsException;
    Integer deleteCustomer(Integer id) throws KvsException;
}
