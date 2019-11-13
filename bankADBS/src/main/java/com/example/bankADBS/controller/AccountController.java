package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Account;
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
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public ResponseEntity<?> getAllAccts(Account accounts){
        List<Account> allAccts = accountService.getAllAccounts(accounts);
        ResponseStateReturn rep = new ResponseStateReturn();
        if(!allAccts.isEmpty()){
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Success");
            rep.setData(allAccts);
            return new ResponseEntity<>(rep,HttpStatus.OK);
        }else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }


    }

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public Optional<Account> getById(@PathVariable Long id){
        return accountService.getById(id);
    }
  
    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}/accounts")
    public ResponseEntity<?> getAcctForCust(@PathVariable Long id){

        List<Account> CustomerAccts =  accountService.getAllCustomerAccounts(id);
        ResponseStateReturn rep = new ResponseStateReturn();
        if(!CustomerAccts.isEmpty()){
            rep.setCode(HttpStatus.OK.value());
            rep.setMessage("Success");
            rep.setData(CustomerAccts);
            return new ResponseEntity<>(rep,HttpStatus.OK);
        }else{
            rep.setCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(rep, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers/{id}/accounts")
        public void addAccount(@RequestBody Account account, @PathVariable Long id) {

        account.setCustomer(id);
        accountService.addAccount(account);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Account account) {
        accountService.updateAccount(account, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
    public void delAccount(@RequestBody Long id){
      accountService.delAccount(id);
    }

}
