package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Deposit;
import org.springframework.data.repository.CrudRepository;

public interface Depository extends CrudRepository<Deposit, String> {
}
