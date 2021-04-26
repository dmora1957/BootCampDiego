package com.desafioproductos.demo.repositories;

import com.desafioproductos.demo.dtos.CustomerDto;
import com.desafioproductos.demo.dtos.CustomerFilterDto;
import com.desafioproductos.demo.exceptions.FileLoadException;
import com.desafioproductos.demo.exceptions.GenericException;
import com.desafioproductos.demo.helpers.FileHandler;
import com.desafioproductos.demo.repositories.interfaces.CustomerRepository;
import com.mercadolibre.kvsclient.IQKVSContainerKvsClient;
import com.mercadolibre.kvsclient.KVSLowLevelClient;
import com.mercadolibre.kvsclient.QKVSContainerLowLevelClient;
import com.mercadolibre.kvsclient.exceptions.KvsException;
import com.mercadolibre.kvsclient.item.Item;
import com.mercadolibre.kvsclient.kvsapi.KvsapiConfiguration;
import com.mercadolibre.kvsclient.kvsapi.KvsapiLowLevelClient;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {

    private List<CustomerDto> customers = null;


    public CustomerRepositoryImp() throws GenericException {
        this.loadDataBase();
    }

    /**
     * Gets the current customer identifier
     * @return an identifier
     */
    private Integer getId()
    {
        CustomerDto latestCustomer = customers
                .stream()
                .max(Comparator.comparing(CustomerDto::getClientId))
                .orElse(new CustomerDto(0));

        return latestCustomer.getClientId()+1;
    }

    /**
     * Get customers
     * @param filter optional name
     * @return customer list
     */
    @Override
    public List<CustomerDto> getCustomers(CustomerFilterDto filter) {
        var result = customers;

        if(filter.getName() != null)
            result = result.stream().filter(customer -> customer.getName().toUpperCase(Locale.ROOT).contains(filter.getName().toUpperCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        if(filter.getProvince() != null)
            result = result.stream().filter(customer -> customer.getProvince().equalsIgnoreCase(filter.getProvince()))
                    .collect(Collectors.toList());

        return result;
    }

    /**
     * Get customer by document
     * @param document document number
     * @return customer
     */
    @Override
    public CustomerDto findCustomerByDocument(String document) {
        CustomerDto result = null;
        Optional<CustomerDto> item = this.customers.stream()
                .filter(c -> c.getDocument().equals(document))
                .findFirst();

        if(item.isPresent())
            result = item.get();

        return result;
    }

    /**
     * Get customer by id
     * @param id customer identifier
     * @return customer
     */
    @Override
    public CustomerDto findCustomerById(Integer id) {
        CustomerDto result = null;
        Optional<CustomerDto> item = this.customers.stream()
                .filter(c -> c.getClientId().equals(id))
                .findFirst();

        if(item.isPresent())
            result = item.get();

        return result;
    }

    @Override
    public CustomerDto updateCustomer(Integer id, CustomerDto newCustomer) throws KvsException {
        KvsapiConfiguration config = KvsapiConfiguration.builder().withMaxRetries(2).build();
        IQKVSContainerKvsClient client = new QKVSContainerLowLevelClient(config, "KEY_VALUE_STORE_MY_CONTAINER_CONTAINER_NAME");
        Item item = new Item();
        item.setValue(newCustomer);
        item.setKey(newCustomer.getDocument());
        client.update(item);
        return newCustomer;
    }

    @Override
    public Integer deleteCustomer(Integer id) throws KvsException {
        KvsapiConfiguration config = KvsapiConfiguration.builder().withMaxRetries(2).build();
        IQKVSContainerKvsClient client = new QKVSContainerLowLevelClient(config, "KEY_VALUE_STORE_MY_CONTAINER_CONTAINER_NAME");

        client.delete(id.toString());
        return id;
    }

    /**
     * Create new customer
     * @param newCustomer new customer object
     * @return customer with identifier
     */
    @Override
    public CustomerDto addCustomer(CustomerDto newCustomer) throws GenericException {
        newCustomer.setClientId(this.getId());
        this.customers.add(newCustomer);

        return newCustomer;
    }

    /**
     * Update database
     */
    private void UpdateDatabase() throws GenericException {
        FileHandler.saveToDataBase("dbCustomers.csv", this.getRows());
    }

    /**
     * parse collection to comma separated data
     * @return List with rows
     */
    private List<String> getRows() {
        List<String> rows = new ArrayList<>();
        rows.add("customerId,name,document,province");
        for (var customer:customers) {
            rows.add(customer.parseToCsvRow());
        }
        return rows;
    }

    /**
     * set the customers in memory list with the data got from database
     * @throws FileLoadException when there is an error loading data base file
     */
    private void loadDataBase() throws GenericException {
        var records = FileHandler.readDataBaseFile("dbCustomersBackUp.csv");
        this.customers = ParseData(records);
    }

    /**
     * Parse data obtained from the database file into a dto list
     * @return a list of customer dto
     * @throws FileLoadException when there is an error loading data base file
     */
    private ArrayList<CustomerDto> ParseData(List<List<String>> records) throws FileLoadException {
        ArrayList<CustomerDto> result = new ArrayList<>();
        try{
            for(int i = 1; i<records.size(); i++)
            {
                var values = records.get(i);
                result.add(new CustomerDto(Integer.parseInt(values.get(0)),values.get(1), values.get(2), values.get(3)));
            }
        }
        catch(Exception ex)
        {
            throw new FileLoadException(ex.getMessage());
        }
        return  result;
        //return getFakeLoad();
    }
}
