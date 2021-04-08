package com.desafioproductos.demo.services;

import com.desafioproductos.demo.dtos.*;
import com.desafioproductos.demo.exceptions.DocumentAlreadyExistsException;
import com.desafioproductos.demo.exceptions.FilterNotValidException;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.exceptions.MissedDataException;
import com.desafioproductos.demo.helpers.CustomerNameSorterAsc;
import com.desafioproductos.demo.helpers.CustomerNameSorterDesc;
import com.desafioproductos.demo.repositories.interfaces.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository _repository;

    public CustomerService(CustomerRepository repository) {
        this._repository = repository;
    }

    /**
     * Gets customers
     * @param filter optional filter
     * @throws FilterNotValidException when an article is not found
     */
    public CustomersCollectionResponseDto getCustomers(CustomerFilterDto filter) throws FilterNotValidException {

        if(filter.getOrder() != null) {
            if (filter.getOrder() < 0 || filter.getOrder() > 1)
                throw new FilterNotValidException("El orden debe ser 0 o 1");
        }

        var result = sortCollection(_repository.getCustomers(filter), filter);
        String responseMessage = "Lista obtenida correctamente";

        if(result.isEmpty())
            responseMessage = "No hay datos";

        return new CustomersCollectionResponseDto(result,responseMessage);
    }

    /**
     * Executes the collection sorting
     * @param customerList all the customers
     * @param filter order value
     * @return a sorted array list with customer dto
     */
    private List<CustomerDto> sortCollection(List<CustomerDto> customerList, CustomerFilterDto filter) {
        try {
            if (filter.getOrder() == null || customerList.size() <= 1)
                return customerList;

            switch (filter.getOrder()) {
                case 0: {
                    customerList.sort(new CustomerNameSorterAsc());
                    break;
                }
                case 1: {
                    customerList.sort(new CustomerNameSorterDesc());
                    break;
                }
            }
            return customerList;
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return  null;
    }

    /**
     * Create new customer
     * @param newCustomer new customer object
     * @return customer with identifier
     */
    public CustomerDto addCustomer(CustomerDto newCustomer) throws GenericException {
        this.validatesCustomer(newCustomer);
        return _repository.addCustomer(newCustomer);
    }

    /**
     * validates new customer
     * @param newCustomer new customer object
     */
    private void validatesCustomer(CustomerDto newCustomer) throws GenericException {
        if(newCustomer.getDocument() == null)
            throw new MissedDataException("Missing document number");
        if(newCustomer.getName() == null)
            throw new MissedDataException("Missing customer name");
        if(newCustomer.getProvince() == null)
            throw new MissedDataException("Missing customer province");
        if(_repository.findCustomerByDocument(newCustomer.getDocument()) != null)
            throw new DocumentAlreadyExistsException(newCustomer.getDocument() + " already exists");
    }
}
