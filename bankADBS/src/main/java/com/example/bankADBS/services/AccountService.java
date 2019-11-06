package com.example.bankADBS.services;


import com.example.bankADBS.domains.Account;


import com.example.bankADBS.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private AccountService accountService;

// Get All Accounts
    public List<Account> getAllAccounts(){
        List<Account> accountList = new ArrayList<>();
        accountRepository.findAll().forEach(accountList::add);
        return accountList;
    }

    // Get Accounts By ID
    public Optional<Account> getById(Long id){
        return accountRepository.findById(id);
    }

    //Get Accounts For Customer
   // public Optional<Customer> getByCustId(Long id){
     //   return accountRepository.findById(id);
    //}


    //Create Account
    public void addAccount(Account account){
        accountRepository.save(account);
    }
    //Update Account
    public void updateAccount(Account account, Long id){
        accountRepository.save(account);
    }

    // Delete By Id
    public void delAccount(Long id){
        accountRepository.deleteById(id);
    }







}
