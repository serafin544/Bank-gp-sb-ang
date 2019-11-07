package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Account;
import com.example.bankADBS.domains.Customer;
import com.example.bankADBS.services.AccountService;
import com.example.bankADBS.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}/customer")
    public List<Account> getCustomersAcct(@PathVariable Long id){
        return accountService.getAllCustomerAccounts(id);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public List<Customer> getListCustomers(){
        return customerService.getAllCustomers();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
    public Optional<Customer> getCustId(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCust(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomerInfo(customer);
    }


}
