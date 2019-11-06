package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Bills;
import com.example.bankADBS.domains.Customer;
import com.example.bankADBS.services.BillService;
import com.example.bankADBS.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class BillController {

  @Autowired
  private BillService billService;

  @Autowired
  private CustomerService customerService;

  @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/bills")
  public List<Bills> getAllBills(){
    return billService.getAllBills();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/bills/{billId}")
  public Optional<Bills> getBillsById(@PathVariable long id){
    return billService.getBillsById(id);
  }

//  @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}/bills")
//  public Optional<Customer> getAllBillsForCustomerById(@PathVariable Long id){
//    return billService
//  }



  @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/bills")
  public void addBill(@RequestBody Bills bills){
    billService.addBill(bills);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/bills/{billId}")
  public void updateBill(@PathVariable long id, @RequestBody Bills bills){
    billService.updateBill(id, bills);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/bills/{billsId}")
  public void deleteBill(@PathVariable long id) {
    billService.deleteBill(id);
  }
}