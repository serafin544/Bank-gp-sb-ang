package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
}
