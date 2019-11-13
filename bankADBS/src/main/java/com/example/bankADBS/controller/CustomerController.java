package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Account;
import com.example.bankADBS.domains.Customer;
import com.example.bankADBS.domains.response.ResponseStateReturn;
import com.example.bankADBS.services.AccountService;
import com.example.bankADBS.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getCustomersAcct(@PathVariable Long id){
        ResponseStateReturn rep = new ResponseStateReturn();
        List<Account> customerAccts = accountService.getAllCustomerAccounts(id);
        if(!customerAccts.isEmpty()){
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Success");
            rep.setData(customerAccts);
            return new ResponseEntity<>(rep,HttpStatus.OK);
        }else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }


    }


    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public ResponseEntity<?> getListCustomers(){
        ResponseStateReturn rep = new ResponseStateReturn();
        List<Customer> allCustomers = customerService.getAllCustomers();
       if(!allCustomers.isEmpty()){
           rep.setCode(HttpStatus.OK.value());
           rep.setMessage("Success");
           rep.setData(allCustomers);
           return new ResponseEntity<>(rep,HttpStatus.OK);
       }else{
           rep.setCode(HttpStatus.NOT_FOUND.value());
           return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
       }

    }
    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
    public ResponseEntity<?> getCustId(@PathVariable Long id){
        Optional<Customer> CertainCustomer = customerService.getCustomerById(id);
        ResponseStateReturn rep = new ResponseStateReturn();
        if(CertainCustomer.isPresent()){
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Success");
            rep.setData(CertainCustomer);
            return new ResponseEntity<>(rep,HttpStatus.OK);
        }else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public void addCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        customerService.addCustomer(customer);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public void updateCust(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomerInfo(customer);
    }


}
