package com.example.bankADBS.services;

import com.example.bankADBS.domains.Customer;
import com.example.bankADBS.repository.CustomerRepository;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){
        List<Customer> listOfCustomers = new ArrayList<>();
        customerRepository.findAll().forEach(listOfCustomers::add);

        return listOfCustomers;
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.findById(id);
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void updateCustomerInfo(Customer customer){
        customerRepository.save(customer);
    }
    public void deleteCustomer( long id ){
        customerRepository.deleteById(id);
    }















}
