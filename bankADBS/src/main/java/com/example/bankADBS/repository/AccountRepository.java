package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Account;
import com.example.bankADBS.domains.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAccountById(Long accountId);
}
