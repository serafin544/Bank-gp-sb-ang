package com.example.bankADBS.controller;

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

  @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountId}/bills")
  public List<Bills> getAllBillsForSpecificAccount(@PathVariable long id, @RequestBody Bills bills){
    return billService.allBillsByAccountId(id);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/bills/{billId}")
  public Optional<Bills> getBillsById(@PathVariable long id){
    return billService.getBillsById(id);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}/bills")

  public List<Bills> getAllBillsForCustomerById(@RequestBody Customer customer, @PathVariable long id, @RequestBody Bills bills){
    return billService.allBillsByCustomerId(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}/bills")
  public void addBill(@RequestBody Bills bills){
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
