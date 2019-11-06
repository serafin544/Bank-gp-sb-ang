package com.example.bankADBS.services;

import com.example.bankADBS.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
}
