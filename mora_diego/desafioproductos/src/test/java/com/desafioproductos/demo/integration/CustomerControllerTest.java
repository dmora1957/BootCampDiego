package com.desafioproductos.demo.integration;

import com.desafioproductos.demo.controllers.CustomerController;
import com.desafioproductos.demo.repositories.interfaces.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ExtendWith(MockitoExtension.class)
@EnableWebMvc
class CustomerControllerTest {

    @Autowired
    CustomerController controller;

    @Mock
    CustomerRepository repo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCustomers() {
    }

    @Test
    void addCustomer() {
    }
}