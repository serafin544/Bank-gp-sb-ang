package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Deposit;
import com.example.bankADBS.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepositController {
    @Autowired
    private DepositService depositService;

    @RequestMapping(method=RequestMethod.GET, value="/accounts/{accountId}/deposits")
    public List<Deposit> getAllDeposits(@PathVariable String accountId){
        return depositService.getAllDeposits(accountId);
    }

    @RequestMapping(method=RequestMethod.GET, value="/deposits/{depositId}")
    public Optional<Deposit> getDeposit(@PathVariable String depositId){
        return depositService.getDepositById(depositId);
    }

    @RequestMapping(method=RequestMethod.POST, value="/accounts/{accountId}/deposits")
    public void addDeposit(@RequestBody Deposit deposit){
        depositService.addDeposit(deposit, deposit.getPayee_id());
    }

    @RequestMapping(method=RequestMethod.PUT, value="/deposits/{depositId}")
    public void updateDeposit(@RequestBody Deposit deposit, @PathVariable String depositId){
        depositService.updateDeposit(deposit, depositId);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deposits/{depositId}")
    public void deleteDeposit(@PathVariable String depositId){
        depositService.deleteDeposit(depositId);
    }
}
