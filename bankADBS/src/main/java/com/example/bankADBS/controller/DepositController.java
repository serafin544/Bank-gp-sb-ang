package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Deposit;
import com.example.bankADBS.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class DepositController {

    @Autowired
    private DepositService depositService;

    @RequestMapping(method=RequestMethod.GET, value="/accounts/{accountId}/deposits")
    public ResponseEntity<?> getAllDepositsForAccount(@PathVariable Long accountId){
        List<Deposit> allDeposits = depositService.getAllDepositsForAccount(accountId);
        if(!allDeposits.isEmpty())
            return new ResponseEntity<>(allDeposits, HttpStatus.OK);
        else
            return new ResponseEntity<>("Message: Error fetching deposits", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=RequestMethod.GET, value="/deposits/{depositId}")
    public ResponseEntity<?> getDeposit(@PathVariable Long depositId){
        Optional<Deposit> deposit = depositService.getDepositById(depositId);
        if(deposit.isPresent())
            return new ResponseEntity<>(deposit, HttpStatus.OK);
        else
            return new ResponseEntity<>("Message: Error fetching deposits", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=RequestMethod.POST, value="/accounts/{accountId}/deposits")
    public ResponseEntity<?> addDeposit(@RequestBody Deposit deposit, @PathVariable Long accountId){
       Deposit d = depositService.addDeposit(deposit, accountId);
        if(d != null){
            HttpHeaders responseHeaders = new HttpHeaders();
            URI newPollUri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(d.getId())
                    .toUri();
            responseHeaders.setLocation(newPollUri);
            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/deposits/{depositId}")
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId){
        Deposit uDeposit = depositService.updateDeposit(deposit, depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deposits/{depositId}")
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        depositService.deleteDeposit(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
