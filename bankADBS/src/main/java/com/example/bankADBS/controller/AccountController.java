package com.example.bankADBS.controller;

import com.example.bankADBS.domains.Account;
import com.example.bankADBS.services.AccountService;
import com.example.bankADBS.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Account> getAllAccts(Account account){
        return accountService.getAllAccounts(account);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{id}")
    public Optional<Account> getById(@PathVariable Long id){
        return accountService.getById(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerid}/accounts")
    public List<Account> getAcctForCust(@PathVariable Long id){
        return accountService.getAllCustomerAccounts(customerService.getCustomerById(id));
    }

  @RequestMapping(method = RequestMethod.POST, value = "/customers/{customerid}/accounts")
    public void addAccount(@RequestBody Account account){accountService.addAccount(account);

  }

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountid}")
public void updateAccount(@PathVariable Long id, @RequestBody Account account) {
        accountService.updateAccount(account, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{accountid}")
    public void delAccount(@RequestBody Long id){
      accountService.delAccount(id);
    }


}
