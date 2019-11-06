package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
