package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Account;
import com.example.bankADBS.domains.Bills;
import com.example.bankADBS.domains.Customer;
import com.example.bankADBS.services.AccountService;
import com.example.bankADBS.services.BillService;
import com.example.bankADBS.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BillController {

  @Autowired
  private BillService billService;



  @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}/bills")
  public List<Bills> getAllBillsForSpecificAccount(@PathVariable Long id, @RequestBody Bills bills){
    return billService.allBillsByAccountId(id);
  }


  @RequestMapping(method = RequestMethod.GET, value = "/bills/{id}")
  public Optional<Bills> getBillsById(@PathVariable Long id){
    return billService.getBillsById(id);
  }


  @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}/bills")
  public List<Bills> getAllBillsForCustomerById(@PathVariable Long id, @RequestBody Bills bills){
    return billService.allBillsByCustomerId(id);
  }



  @RequestMapping(method = RequestMethod.POST, value = "/accounts/{id}/bills")
  public void addBill(@PathVariable Long id, @RequestBody Bills bills){
    billService.addBill(bills);
  }


  @RequestMapping(method = RequestMethod.PUT, value = "/bills/{id}")
  public void updateBill(@PathVariable Long id, @RequestBody Bills bills){
    billService.updateBill(id, bills);
  }


  @RequestMapping(method = RequestMethod.DELETE, value = "/bills/{id}")
  public void deleteBill(@PathVariable Long id) {
    billService.deleteBill(id);
  }
}
