package com.desafioproductos.demo.services;

import com.desafioproductos.demo.fixtures.ArticleDtoFixture;
import com.desafioproductos.demo.fixtures.CustomerFixture;
import com.desafioproductos.demo.repositories.ArticleRepositoryImp;
import com.desafioproductos.demo.repositories.CustomerRepositoryImp;
import com.desafioproductos.demo.repositories.interfaces.CustomerRepository;
import com.desafioproductos.demo.services.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository repo = Mockito.mock(CustomerRepository.class);

    @BeforeEach
    void setUp() {
        repo = Mockito.mock(CustomerRepositoryImp.class);
        when(repo.getCustomers(any())).thenReturn(CustomerFixture.getCustomers());
        //this.service = new ArticleService(repo);
    }

    @Test
    @DisplayName("obtener clientes")
    void getCustomers() {

    }

    @Test
    @DisplayName("Agregar cliente")
    void addCustomer() {
    }
}